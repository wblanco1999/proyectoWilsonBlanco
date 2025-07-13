/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalwb.main;

import com.proyectofinalwb.enums.Periocidad;

/**
 *
 * @author wilsonblanco
 */
public abstract class Gasto {
    protected String id;
    protected String nombre;
    protected double monto;
    protected Periocidad periocidad;

    public Gasto(String id, String nombre, double monto, Periocidad periocidad) {
        this.id = id;
        this.nombre = nombre;
        this.monto = monto;
        this.periocidad = periocidad;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Periocidad getPeriocidad() {
        return periocidad;
    }

    public void setPeriocidad(Periocidad periocidad) {
        this.periocidad = periocidad;
    }
    
    
}
