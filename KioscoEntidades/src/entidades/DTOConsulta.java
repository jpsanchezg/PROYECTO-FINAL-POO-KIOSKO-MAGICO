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
public class DTOConsulta {
    
    private String mensaje;
    private LocalDate fechaPrestamo;
    private int numero;
    private List <Linea> lineasPrestamo = new ArrayList <> ();
    private double totalPrestamo;

    public DTOConsulta() {
    }

    public DTOConsulta(String mensaje, LocalDate fechaPrestamo, int numero, double totalPrestamo) {
        this.mensaje = mensaje;
        this.fechaPrestamo = fechaPrestamo;
        this.numero = numero;
        this.totalPrestamo = totalPrestamo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<Linea> getLineasPrestamo() {
        return lineasPrestamo;
    }

    public void setLineasPrestamo(List<Linea> lineasPrestamo) {
        this.lineasPrestamo = lineasPrestamo;
    }

    public double getTotalPrestamo() {
        return totalPrestamo;
    }

    public void setTotalPrestamo(double totalPrestamo) {
        this.totalPrestamo = totalPrestamo;
    }
    
}
