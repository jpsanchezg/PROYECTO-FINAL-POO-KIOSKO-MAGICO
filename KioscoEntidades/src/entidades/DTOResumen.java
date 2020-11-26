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
public class DTOResumen {
    
    private String mensaje;
    private List <Linea> lineas = new ArrayList <> ();
    private boolean verf;
    private double total;
    private double saldo;
    private double vueltas;

    public DTOResumen() {
    }

    public DTOResumen(String mensaje, boolean verf, double total, double saldo, double vueltas) {
        this.mensaje = mensaje;
        this.verf = verf;
        this.total = total;
        this.saldo = saldo;
        this.vueltas = vueltas;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<Linea> getLineas() {
        return lineas;
    }

    public void setLineas(List<Linea> lineas) {
        this.lineas = lineas;
    }

    public boolean isVerf() {
        return verf;
    }

    public void setVerf(boolean verf) {
        this.verf = verf;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getVueltas() {
        return vueltas;
    }

    public void setVueltas(double vueltas) {
        this.vueltas = vueltas;
    }
    
}
