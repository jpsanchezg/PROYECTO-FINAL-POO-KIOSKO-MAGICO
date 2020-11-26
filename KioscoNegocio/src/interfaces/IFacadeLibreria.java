/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.DTOConsulta;
import entidades.DTOReporte;
import entidades.DTOResumen;
import entidades.Denominacion;
import entidades.Libro;
import entidades.Linea;
import entidades.Prestamo;
import java.util.List;

/**
 *
 * @author Santiago Fernández Becerra - Juan Pablo Sánchez Gaitán - José Daniel
 * Niño Muñoz
 */
public interface IFacadeLibreria {

    String NumeroPrestamo();

    List<Libro> getCatalogo();

    Prestamo getPrestamoActual();

    boolean crearNuevoPrestamo();

    DTOResumen agregarLinea(Libro libro, int cantidad);

    DTOResumen eliminarLinea(Linea linea);

    DTOResumen introducirMonedas(Denominacion den, int cantidad);

    DTOResumen terminarPrestamo();

    DTOConsulta consultarPrestamo(int numero);

    DTOReporte reporteDiario();

}
