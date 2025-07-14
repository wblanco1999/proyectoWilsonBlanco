/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalwb.main;

import java.util.Date;

/**
 *
 * @author wilsonblanco
 */

// La diferencia entre esta clase y gasto, es que la clase transacción confirma si un monto puede ser negativo u positivo.
// Un gasto no necesariamente es algo que ya ha pasado, mientras que una transacción es  un movimiento que de dinero 
// positivo o negativo en una cuenta.
public class Transaccion {
    private String id;
    private Date fecha;
    private boolean egreso;
    private double monto;

    public Transaccion(String id, boolean egreso, double monto) {
        this.id = id;
        this.egreso = egreso;
        this.monto = monto;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isEgreso() {
        return egreso;
    }

    public void setEgreso(boolean egreso) {
        this.egreso = egreso;
    }

    @Override
    public String toString() {
        return "\nTransaccion" + "ID: " + id + " Fecha" + fecha + " Egreso: " + egreso+ "Monto: ₡"+monto;
    }
    
    
    
}
