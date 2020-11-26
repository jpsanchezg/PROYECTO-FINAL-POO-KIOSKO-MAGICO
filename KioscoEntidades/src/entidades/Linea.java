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
public class Linea {
    
    private int cantidad;
    private double valorTotal;
    private double subTotal;
    
    private Libro libroEnPrestamo;

    public Linea() {
    }

    public Linea(int cantidad, Libro libroEnPrestamo) {
        this.cantidad = cantidad;
        this.libroEnPrestamo = libroEnPrestamo;
    }

    public Linea(int cantidad, double valorTotal, double subTotal, Libro libroEnPrestamo) {
        this.cantidad = cantidad;
        this.valorTotal = valorTotal;
        this.subTotal = subTotal;
        this.libroEnPrestamo = libroEnPrestamo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public Libro getLibroEnPrestamo() {
        return libroEnPrestamo;
    }

    public void setLibroEnPrestamo(Libro libroEnPrestamo) {
        this.libroEnPrestamo = libroEnPrestamo;
    }
}
    
