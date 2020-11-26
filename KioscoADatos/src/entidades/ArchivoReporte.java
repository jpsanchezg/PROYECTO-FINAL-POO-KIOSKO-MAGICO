/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import entidades.DTOReporte;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Santiago Fernández Becerra - Juan Pablo Sánchez Gaitán - José Daniel Niño Muñoz
 */
public class ArchivoReporte {
    
    @XmlElement(name = "reporte")
    private DTOReporte reporte;

    public ArchivoReporte() {
    }

    public ArchivoReporte(DTOReporte reporte) {
        this.reporte = reporte;
    }

    public DTOReporte getReporte() {
        return reporte;
    }

    public void setReporte(DTOReporte reporte) {
        this.reporte = reporte;
    }
    
}
