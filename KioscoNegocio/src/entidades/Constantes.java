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
public class Constantes {
    
    private static final double VALOR_IMAGEN=500;
    private static final double VALOR_VIDEO=1000;
    private static final String RUTA_ARCHIVO="archivoLibros.xml";
    private static final String RUTA_REPORTE="archivoReporte.xml";

    public Constantes() {
    }

    public static double getVALOR_IMAGEN() {
        return VALOR_IMAGEN;
    }

    public static double getVALOR_VIDEO() {
        return VALOR_VIDEO;
    }

    public static String getRUTA_ARCHIVO() {
        return RUTA_ARCHIVO;
    }

    public static String getRUTA_REPORTE() {
        return RUTA_REPORTE;
    }
    
}
