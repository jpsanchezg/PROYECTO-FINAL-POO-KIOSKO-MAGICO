/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Santiago Fernández Becerra - Juan Pablo Sánchez Gaitán - José Daniel Niño Muñoz
 */
public class DTOReporte {
    
    private List <DTOVenta> ventas = new ArrayList <> ();
    private int cantidadLibros;
    private int cantidadTotalVendida;
    private double totalVentas;
    private int monedasMaquina;

    public DTOReporte() {
    }

    public DTOReporte(int cantidadLibros, int cantidadTotalVendida, double totalVentas, int monedasMaquina) {
        this.cantidadLibros = cantidadLibros;
        this.cantidadTotalVendida = cantidadTotalVendida;
        this.totalVentas = totalVentas;
        this.monedasMaquina = monedasMaquina;
    }

    public List<DTOVenta> getVentas() {
        return ventas;
    }

    public void setVentas(List<DTOVenta> ventas) {
        this.ventas = ventas;
    }

    public int getCantidadLibros() {
        return cantidadLibros;
    }

    public void setCantidadLibros(int cantidadLibros) {
        this.cantidadLibros = cantidadLibros;
    }

    public int getCantidadTotalVendida() {
        return cantidadTotalVendida;
    }

    public void setCantidadTotalVendida(int cantidadTotalVendida) {
        this.cantidadTotalVendida = cantidadTotalVendida;
    }

    public double getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(double totalVentas) {
        this.totalVentas = totalVentas;
    }

    public int getMonedasMaquina() {
        return monedasMaquina;
    }

    public void setMonedasMaquina(int monedasMaquina) {
        this.monedasMaquina = monedasMaquina;
    }
    
}
