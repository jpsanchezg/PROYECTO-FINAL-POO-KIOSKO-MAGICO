/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Santiago Fernández Becerra - Juan Pablo Sánchez Gaitán - José Daniel Niño Muñoz
 */
public class DTOVenta {
    
    private String nombreLibro;
    private int librosVendidos;
    private double valorLibrosVendidos;

    public DTOVenta() {
    }

    public DTOVenta(String nombreLibro, int librosVendidos, double valorLibrosVendidos) {
        this.nombreLibro = nombreLibro;
        this.librosVendidos = librosVendidos;
        this.valorLibrosVendidos = valorLibrosVendidos;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public int getLibrosVendidos() {
        return librosVendidos;
    }

    public void setLibrosVendidos(int librosVendidos) {
        this.librosVendidos = librosVendidos;
    }

    public double getValorLibrosVendidos() {
        return valorLibrosVendidos;
    }

    public void setValorLibrosVendidos(double valorLibrosVendidos) {
        this.valorLibrosVendidos = valorLibrosVendidos;
    }
    
}
