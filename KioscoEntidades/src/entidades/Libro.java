/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Santiago Fernández Becerra - Juan Pablo Sánchez Gaitán - José Daniel Niño Muñoz
 */
public class Libro {
    
    private String nombre;
    private String isbn;
    private double precioBase;
    private int unidadesDisponibles;
    private int numeroImagenes;
    private int numeroVideos;

    public Libro() {
    }

    public Libro(String nombre, String isbn, double precioBase, int unidadesDisponible, int numeroImagenes, int numeroVideos) {
        this.nombre = nombre;
        this.isbn = isbn;
        this.precioBase = precioBase;
        this.unidadesDisponibles = unidadesDisponible;
        this.numeroImagenes = numeroImagenes;
        this.numeroVideos = numeroVideos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public int getNumeroImagenes() {
        return numeroImagenes;
    }

    public void setNumeroImagenes(int numeroImagenes) {
        this.numeroImagenes = numeroImagenes;
    }

    public int getNumeroVideos() {
        return numeroVideos;
    }

    public void setNumeroVideos(int numeroVideos) {
        this.numeroVideos = numeroVideos;
    }

    @Override
    public String toString() {
        return "Libro{" + "nombre=" + nombre + ", isbn=" + isbn + ", precioBase=" + precioBase + ", unidadesDisponible=" + unidadesDisponibles + ", numeroImagenes=" + numeroImagenes + ", numeroVideos=" + numeroVideos + '}';
    }
/**
    @Override
    public String toString() {
        return this.nombre;
    }**/
    
    
    
}
