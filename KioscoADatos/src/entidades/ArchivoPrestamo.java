/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import entidades.Prestamo;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Santiago Fernández Becerra - Juan Pablo Sánchez Gaitán - José Daniel Niño Muñoz
 */
public class ArchivoPrestamo {
    
    @XmlElement(name = "prestamo")
    private Prestamo actual;

    public ArchivoPrestamo() {
    }

    public ArchivoPrestamo(Prestamo actual) {
        this.actual = actual;
    }

    public Prestamo getActual() {
        return actual;
    }

    public void setActual(Prestamo actual) {
        this.actual = actual;
    }
    
}
