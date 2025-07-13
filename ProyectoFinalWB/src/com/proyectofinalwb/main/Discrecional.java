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
public class Discrecional extends Gasto {
    private boolean impulso;
    private String frecuencia;
    private String descripcion;

    public Discrecional(boolean impulso, String frecuencia, String descripcion, String id, String nombre, double monto, Periocidad periocidad) {
        super(id, nombre, monto, periocidad);
        this.impulso = impulso;
        this.frecuencia = frecuencia;
        this.descripcion = descripcion;
    }
    
    
    
    public boolean isImpulso() {
        return impulso;
    }

    public void setImpulso(boolean impulso) {
        this.impulso = impulso;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
