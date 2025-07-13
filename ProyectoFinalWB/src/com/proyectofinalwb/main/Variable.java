/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalwb.main;

import com.proyectofinalwb.enums.Periocidad;
import com.proyectofinalwb.enums.Prioridad;

/**
 *
 * @author wilsonblanco
 */
public class Variable extends Gasto{
    private double presupuestoMax;
    private Prioridad prioridad;
    private boolean temporadaAlta;

    public Variable(double presupuestoMax, Prioridad prioridad, boolean temporadaAlta, String id, String nombre, double monto, Periocidad periocidad) {
        super(id, nombre, monto, periocidad);
        this.presupuestoMax = presupuestoMax;
        this.prioridad = prioridad;
        this.temporadaAlta = temporadaAlta;
    }
    
    
    
    public double getPresupuestoMax() {
        return presupuestoMax;
    }

    public void setPresupuestoMax(double presupuestoMax) {
        this.presupuestoMax = presupuestoMax;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public boolean isTemporadaAlta() {
        return temporadaAlta;
    }

    public void setTemporadaAlta(boolean temporadaAlta) {
        this.temporadaAlta = temporadaAlta;
    }
    
    
    
}
