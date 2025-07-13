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
public class Transaccion {
    private String id;
    private Date fecha;
    private boolean egreso;

    public Transaccion(String id, boolean egreso) {
        this.id = id;
        this.egreso = egreso;
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
    
    
}
