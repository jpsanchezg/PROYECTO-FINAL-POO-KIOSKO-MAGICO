/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entidades.Constantes;
import entidades.DTOConsulta;
import entidades.DTOReporte;
import entidades.DTOResumen;
import entidades.DTOVenta;
import entidades.Denominacion;
import entidades.Libro;
import entidades.Linea;
import entidades.Moneda;
import entidades.Prestamo;
import interfaces.IFacadeLibreria;
import interfaces.IGestionLibro;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Santiago Fernández Becerra - Juan Pablo Sánchez Gaitán - José Daniel
 * Niño Muñoz
 */
public class FacadeLibreria implements IFacadeLibreria {

    private List<Libro> catalogo = new ArrayList<>();
    private List<Prestamo> prestamos = new ArrayList<>();
    private Prestamo prestamoActual;
    private IGestionLibro gestionLibro = new GestionLibro();

    public FacadeLibreria() {
        this.catalogo = this.gestionLibro.cargarLibros();//1.b.
    }

    @Override
    public List<Libro> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(List<Libro> catalogo) {
        this.catalogo = catalogo;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    @Override
    public Prestamo getPrestamoActual() {
        return prestamoActual;
    }

    public void setPrestamoActual(Prestamo prestamoActual) {
        this.prestamoActual = prestamoActual;
    }

    public IGestionLibro getGestionLibro() {
        return gestionLibro;
    }

    public void setGestionLibro(IGestionLibro gestionLibro) {
        this.gestionLibro = gestionLibro;
    }

    @Override
    public boolean crearNuevoPrestamo() {//2.
        if (this.catalogo.isEmpty()) {
            return false;
        }
        Prestamo actual = new Prestamo(LocalDate.now(), this.prestamos.size() + 1);//2.c.
        this.prestamoActual = actual;//2.b.
        this.prestamos.add(this.prestamoActual);//2.a.
        return true;
    }

    @Override
    public String NumeroPrestamo() {
        String num = String.valueOf(this.getPrestamoActual().getNumero());
        return num;
    }

    private boolean verificarCatalogo(Libro libro) {//3.a.
        if (this.catalogo.contains(libro)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean verificarLineas(Libro libro) {
        for (Linea actual : this.prestamoActual.getLineas()) {
            if (actual.getLibroEnPrestamo().equals(libro)) {
                return true;
            }
        }
        return false;
    }

    private boolean verificarExistencias(Libro libro, int cantidad) {//3.b.
        if (!verificarLineas(libro)) {
            if (cantidad <= libro.getUnidadesDisponibles()) {
                return true;
            }
        } else {
            for (Linea actual : this.prestamoActual.getLineas()) {
                if (actual.getLibroEnPrestamo().equals(libro)) {
                    if ((cantidad+actual.getCantidad()) <= actual.getLibroEnPrestamo().getUnidadesDisponibles()) {
                        int uniA = actual.getCantidad();
                        actual.setCantidad(uniA+cantidad);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private Linea crearLinea(Libro libro, int cantidad) {//3.c.
        Linea nueva = new Linea(cantidad, libro);
        this.prestamoActual.getLineas().add(nueva);
        return nueva;
    }

    private double calcularValor(Libro libro) {//3.d.
        return (libro.getPrecioBase() + (libro.getNumeroImagenes() * Constantes.getVALOR_IMAGEN()) + (libro.getNumeroVideos() * Constantes.getVALOR_VIDEO()));
    }

    private double calcularSubTotal(Linea linea) {//3.e.
        linea.setValorTotal(calcularValor(linea.getLibroEnPrestamo()));
        linea.setSubTotal(linea.getValorTotal() * linea.getCantidad());
        return linea.getSubTotal();
    }

    private double calcularTotalPrestamo() {//3.f.
        double total = 0;
        for (Linea actual : this.prestamoActual.getLineas()) {
            total += calcularSubTotal(actual);
        }
        return total;
    }

    private DTOResumen crearDTOResumen(Libro libro, int cantidad) {//3.g.
        DTOResumen informe = new DTOResumen();
        informe.setMensaje(null);//Mensaje
        informe.getLineas().add(crearLinea(libro, cantidad));//Agregar Linea
        informe.setVerf(true);//Creación Positiva
        informe.setTotal(calcularTotalPrestamo());//Total
        return informe;
    }

    @Override
    public DTOResumen agregarLinea(Libro libro, int cantidad) {//3.
        boolean vericata = verificarCatalogo(libro), veriexi = verificarExistencias(libro, cantidad), verifi = verificarLineas(libro);
        DTOResumen informe = new DTOResumen();
        if (vericata == true && veriexi == true) {
            informe = crearDTOResumen(libro, cantidad);
        } else {
            informe.setMensaje("No se pudo agregar línea de prestamo");
        }
        return informe;
    }

    private boolean verificarLinea(Linea linea) {//4.a.
        if (linea.equals(null)) {
            return false;
        }
        return true;
    }

    private boolean quitarLinea(Linea linea) {//4.b.
        for (Linea actual : this.prestamoActual.getLineas()) {
            if (actual.equals(linea)) {
                this.prestamoActual.getLineas().remove(actual);
                return true;
            }
        }
        return false;
    }

    private DTOResumen crearDTOResumen(Linea linea) {//4.c.
        DTOResumen informe = new DTOResumen();
        informe.setMensaje(null);//Mensaje
        boolean verf = quitarLinea(linea);
        informe.setVerf(verf);//Eliminación Positiva
        informe.setLineas(this.prestamoActual.getLineas());//Reasignación de lineas
        informe.setTotal(calcularTotalPrestamo());//Total Prestamo
        return informe;
    }

    @Override
    public DTOResumen eliminarLinea(Linea linea) {//4.
        DTOResumen informe = new DTOResumen();
        if (verificarLinea(linea) && quitarLinea(linea)) {
            informe = crearDTOResumen(linea);
        } else {
            informe.setMensaje("La linea no pudo ser borrada");
        }
        return informe;
    }

    private boolean verificarDenominacion(Denominacion den) {//5.a.
        for (Denominacion actual : Denominacion.values()) {
            if (actual.equals(den)) {
                return true;
            }
        }
        return false;
    }

    private Moneda crearMoneda(Denominacion den) {//5.b.
        Moneda nueva = new Moneda(den);
        this.prestamoActual.getPagoMonedas().add(nueva);//5.c.
        return nueva;
    }

    private double calcularSaldo() {
        double total = 0;
        for (Moneda actual : this.prestamoActual.getPagoMonedas()) {
            total += actual.getDenominacion().getValor();
        }
        return total;
    }

    private DTOResumen crearDTOResumen(Denominacion den) {//5.d.
        DTOResumen informe = new DTOResumen();
        informe.setMensaje(null);//Mensaje
        informe.setLineas(this.prestamoActual.getLineas());//Líneas
        informe.setVerf(true);//Verificación
        informe.setTotal(calcularTotalPrestamo());//Total Prestamo
        informe.setSaldo(calcularSaldo());//Total Saldo
        return informe;
    }

    @Override
    public DTOResumen introducirMonedas(Denominacion den, int cantidad) {//5.
        DTOResumen informe = new DTOResumen();
        if (verificarDenominacion(den)) {
            Moneda nueva = crearMoneda(den);
            this.prestamoActual.getPagoMonedas().add(nueva);
            informe = crearDTOResumen(den);
        } else {
            informe.setMensaje("Denominación no aceptada");
        }
        return informe;
    }

    private boolean verificarSaldo() {//6.a.
        if (calcularSaldo() >= calcularTotalPrestamo()) {
            return true;
        }
        return false;
    }

    private void actualizarExistencias() {//6.b.
        for (Linea actual : this.prestamoActual.getLineas()) {
            Libro lineaLibro = actual.getLibroEnPrestamo();
            int uniD = this.catalogo.get(this.catalogo.indexOf(lineaLibro)).getUnidadesDisponibles();
            this.catalogo.get(this.catalogo.indexOf(lineaLibro)).setUnidadesDisponibles(uniD - actual.getCantidad());
        }
    }

    private double devolverSaldo() {//6.e.
        return (calcularSaldo() - calcularTotalPrestamo());
    }

    private DTOResumen crearDTOResumen() {//6.f.
        DTOResumen informe = new DTOResumen();
        informe.setMensaje(null);//Mensaje
        informe.setLineas(this.prestamoActual.getLineas());//Líneas
        informe.setVerf(true);//Verificación
        informe.setTotal(calcularTotalPrestamo());//Total Prestamo
        informe.setSaldo(calcularSaldo());//Total Saldo
        informe.setVueltas(devolverSaldo());//Total Vueltas
        return informe;
    }

    @Override
    public DTOResumen terminarPrestamo() {//6.
        DTOResumen informe = new DTOResumen();
        if (verificarSaldo()) {
            actualizarExistencias();
            gestionLibro.persistirPrestamo(this.prestamoActual);//6.d.
            informe = crearDTOResumen();
        } else {
            informe.setMensaje("Error al terminar el prestamo");
        }
        return informe;
    }

    private Prestamo buscarPrestamo(int numero) {
        for (Prestamo actual : this.prestamos) {
            if (actual.getNumero() == numero) {
                return actual;
            }
        }
        return null;
    }

    private double calcularTotalPrestamo(Prestamo buscado) {
        double total = 0;
        for (Linea actual : buscado.getLineas()) {
            total += calcularSubTotal(actual);
        }
        return total;
    }

    private DTOConsulta crearDTOConsulta(Prestamo buscado) {
        DTOConsulta informe = new DTOConsulta();
        informe.setMensaje(null);//Mensaje
        informe.setFechaPrestamo(buscado.getFecha());//Fecha Prestamo
        informe.setNumero(buscado.getNumero());//Número Prestamo
        informe.setLineasPrestamo(buscado.getLineas());//Líneas Prestamo
        informe.setTotalPrestamo(calcularTotalPrestamo(buscado));//Total Prestamo
        return informe;
    }

    @Override
    public DTOConsulta consultarPrestamo(int numero) {//7.
        DTOConsulta informe = new DTOConsulta();
        Prestamo buscado = buscarPrestamo(numero);
        if (buscado != null) {
            informe = crearDTOConsulta(buscado);
        } else {
            informe.setMensaje("No se pudo consultar el prestamo correctamente");
        }
        return informe;
    }

    private List<DTOVenta> crearVentas() {
        List<DTOVenta> ventas = new ArrayList<>();
        DTOVenta venta;
        for (Libro lActual : this.catalogo) {
            String nombre = null;
            int cont = 0;
            double total = 0;
            for (Prestamo pActual : this.prestamos) {
                for (Linea liActual : pActual.getLineas()) {
                    if (liActual.getLibroEnPrestamo().equals(lActual)) {
                        nombre = liActual.getLibroEnPrestamo().getNombre();
                        cont += liActual.getCantidad();
                        total += calcularSubTotal(liActual);
                    }
                }
            }
            venta = new DTOVenta(nombre, cont, total);
            ventas.add(venta);
        }
        return ventas;
    }

    private int calcularCantidadLibros() {
        int cont = 0;
        for (Libro actual : this.catalogo) {
            cont += actual.getUnidadesDisponibles();
        }
        return cont;
    }

    private int calcularLibrosVendidos() {
        int cont = 0;
        for (Prestamo pActual : this.prestamos) {
            for (Linea lActual : pActual.getLineas()) {
                cont += lActual.getCantidad();
            }
        }
        return cont;
    }

    private double calcularTotalVentas() {
        double total = 0;
        for (Prestamo actual : this.prestamos) {
            total += calcularTotalPrestamo(actual);
        }
        return total;
    }

    private int totalMonedas() {
        int cont = 0;
        for (Prestamo actual : this.prestamos) {
            cont += actual.getPagoMonedas().size();
        }
        return cont;
    }

    @Override
    public DTOReporte reporteDiario() {//8.
        DTOReporte informe = new DTOReporte();
        informe.setVentas(crearVentas());//Ventas
        informe.setCantidadLibros(calcularCantidadLibros());//Total de libros
        informe.setCantidadTotalVendida(calcularLibrosVendidos());//Total de libros vendidos
        informe.setTotalVentas(calcularTotalVentas());//Total acumulado de las ventas
        informe.setMonedasMaquina(totalMonedas());
        this.gestionLibro.persistirReporte(informe);
        return informe;
    }

}
