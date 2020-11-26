/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Santiago Fernández Becerra - Juan Pablo Sánchez Gaitán - José Daniel Niño Muñoz
 */
public class Prestamo {
    
    private LocalDate fecha;
    private int numero;
    
    private List <Moneda> pagoMonedas = new ArrayList <> ();
    private List <Linea> lineas = new ArrayList <> ();

    public Prestamo() {
    }

    public Prestamo(LocalDate fecha, int numero) {
        this.fecha = fecha;
        this.numero = numero;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<Moneda> getPagoMonedas() {
        return pagoMonedas;
    }

    public void setPagoMonedas(List<Moneda> pagoMonedas) {
        this.pagoMonedas = pagoMonedas;
    }

    public List<Linea> getLineas() {
        return lineas;
    }

    public void setLineas(List<Linea> lineas) {
        this.lineas = lineas;
    }
    
}
