/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalwb.main;

import com.proyectofinalwb.enums.Periocidad;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author wilsonblanco
 */
public abstract class Gasto implements Serializable{
    protected String id;
    protected String nombre;
    protected double monto;
    protected Periocidad periocidad;
    protected String presupuestoId;

    public Gasto(String nombre, double monto, Periocidad periocidad, String presupuestoId) {
        this.id = ID.agregarID();
        this.nombre = nombre;
        this.monto = monto;
        this.periocidad = periocidad;
        this.presupuestoId = presupuestoId;
    }

    public Gasto() {
    }

    public Gasto(String presupuestoId) {
        this.presupuestoId = presupuestoId;
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

    public String getPresupuestoId() {
        return presupuestoId;
    }

    public void setPresupuestoId(String presupuestoId) {
        this.presupuestoId = presupuestoId;
    }
    
    
    
    @Override
    public String toString() {
        return "Gasto{" + "id=" + id + ", nombre=" + nombre + ", monto=" + monto + ", periocidad=" + periocidad + '}';
    } 
    public abstract String tipoDeGasto();
    public abstract boolean insertarDAO();
    public abstract boolean eliminarDAO();
    public abstract boolean modificarDAO();
    public abstract List<Gasto> obtenerDAO();
    
}
