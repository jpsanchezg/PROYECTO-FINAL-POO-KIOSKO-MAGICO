/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Santiago Fernández Becerra - Juan Pablo Sánchez Gaitán - José Daniel Niño Muñoz
 */
@XmlRootElement(name="archivoLibros")
@XmlAccessorType(XmlAccessType.FIELD)
public class ArchivoLibros {
    
    @XmlElement(name="libro")
    private List <Libro> catalogo = new ArrayList <> ();

    public ArchivoLibros() {
    }
    
    public ArchivoLibros(List <Libro> catalogo){
        this.catalogo = catalogo;
    }

    public List<Libro> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(List<Libro> catalogo) {
        this.catalogo = catalogo;
    }
    
}
