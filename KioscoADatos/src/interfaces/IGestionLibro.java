/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.DTOReporte;
import entidades.Libro;
import entidades.Prestamo;
import java.util.List;

/**
 *
 * @author Santiago Fernández Becerra - Juan Pablo Sánchez Gaitán - José Daniel Niño Muñoz
 */
public interface IGestionLibro {
    
    List <Libro> cargarLibros();
    boolean persistirPrestamo(Prestamo actual);
    boolean persistirReporte(DTOReporte reporte);
    
}
