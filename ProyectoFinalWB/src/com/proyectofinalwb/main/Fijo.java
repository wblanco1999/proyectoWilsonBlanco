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
public class Fijo extends Gasto {
    private boolean caducidad;
    private int plazo;
    private Prioridad prioridad;

    public Fijo(boolean caducidad, int plazo, Prioridad prioridad, String id, String nombre, double monto, Periocidad periocidad) {
        super(id, nombre, monto, periocidad);
        this.caducidad = caducidad;
        this.plazo = plazo;
        this.prioridad = prioridad;
    }
    
    public boolean isCaducidad() {
        return caducidad;
    }

    public void setCaducidad(boolean caducidad) {
        this.caducidad = caducidad;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }
    
    
}
