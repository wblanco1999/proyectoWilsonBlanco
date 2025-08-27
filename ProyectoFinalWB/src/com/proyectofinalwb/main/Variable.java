/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalwb.main;

import com.proyectofinalwb.dao.VariableDAO;
import com.proyectofinalwb.enums.Periocidad;
import com.proyectofinalwb.enums.Prioridad;
import com.proyectofinalwb.sql.VariableSQL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wilsonblanco
 */
public class Variable extends Gasto {

    private double presupuestoMax;
    private Prioridad prioridad;
    private boolean temporadaAlta;

    public Variable() {
    }

    public Variable(String presupuestoId) {
        super(presupuestoId);
    }


    public Variable(double presupuestoMax, Prioridad prioridad, boolean temporadaAlta, String nombre, double monto, Periocidad periocidad, String presupuestoId) {
        super(nombre, monto, periocidad, presupuestoId);
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

    @Override
    public String tipoDeGasto() {
        return "Variable";
    }

    @Override
    public boolean insertarDAO() {
        VariableDAO dao = new VariableSQL();
        return dao.insertar(this);
    }

    @Override
    public boolean eliminarDAO() {
        VariableDAO dao = new VariableSQL();
        return dao.eliminar(this);
    }

    @Override
    public boolean modificarDAO() {
        VariableDAO dao = new VariableSQL();
        return dao.modificar(this);
    }

    @Override
    public List<Gasto> obtenerDAO() {
        VariableDAO dao = new VariableSQL();
        List<Variable> fijos = dao.obtener(this);
        List<Gasto> gastos = new ArrayList<>(fijos.size());
        gastos.addAll(fijos);
        return gastos;
    }

 

}
