/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entidades.ArchivoLibros;
import entidades.ArchivoPrestamo;
import entidades.ArchivoReporte;
import entidades.Constantes;
import entidades.DTOReporte;
import entidades.Libro;
import entidades.Prestamo;
import interfaces.IGestionLibro;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javax.xml.bind.JAXB;

/**
 *
 * @author Santiago Fernández Becerra - Juan Pablo Sánchez Gaitán - José Daniel Niño Muñoz
 */
public class GestionLibro implements IGestionLibro{

    public GestionLibro() {
    }

    @Override
    public List<Libro> cargarLibros() {//1.a.
        try (BufferedReader input = Files.newBufferedReader(Paths.get("archivoLibros.xml"))){
            ArchivoLibros libreria = JAXB.unmarshal(input, ArchivoLibros.class);
            return libreria.getCatalogo();
        }catch(IOException ioe){
            ioe.printStackTrace();
            return null;
        }
    }
    
    @Override
    public boolean persistirPrestamo(Prestamo actual){//6.d.
        ArchivoPrestamo registro = new ArchivoPrestamo(actual);
        try(BufferedWriter output = Files.newBufferedWriter(Paths.get("C:\\Users\\cacab\\Desktop\\O.O.P-Proyect-master\\Reporte\\archivoPrestamo.xml"))){
            JAXB.marshal(registro, output);
            return true;
        }catch(IOException ioe){
            ioe.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean persistirReporte(DTOReporte reporte){
        ArchivoReporte registro = new ArchivoReporte(reporte);
        String ruta = Constantes.getRUTA_REPORTE();
        try(BufferedWriter output = Files.newBufferedWriter(Paths.get(ruta))){
            JAXB.marshal(registro, output);
            return true;
        }catch(IOException ioe){
            ioe.printStackTrace();
            return false;
        }
    }
    
}
