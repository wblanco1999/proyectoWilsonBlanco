/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalwb.main;

import com.proyectofinalwb.dao.FijoDAO;
import com.proyectofinalwb.enums.Periocidad;
import com.proyectofinalwb.enums.Prioridad;
import com.proyectofinalwb.sql.FijoSQL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wilsonblanco
 */
public class Fijo extends Gasto {

    private boolean caducidad;
    private int plazo;
    private Prioridad prioridad;

    public Fijo() {
    }

    public Fijo(String presupuestoId) {
        super(presupuestoId);
    }
    
    public Fijo(boolean caducidad, int plazo, Prioridad prioridad, String presupuestoId, String nombre, double monto, Periocidad periocidad) {
        super(nombre, monto, periocidad, presupuestoId);
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

    @Override
    public String toString() {
        return super.toString() + " Fijo{" + "caducidad=" + caducidad + ", plazo=" + plazo + ", prioridad=" + prioridad + '}';
    }

    @Override
    public String tipoDeGasto() {
        return "Fijo";
    }

    @Override
    public boolean insertarDAO() {
        FijoDAO fDAO = new FijoSQL();
        return fDAO.insertar(this);

    }

    @Override
    public boolean eliminarDAO() {
        FijoDAO fDAO = new FijoSQL();
        return fDAO.eliminar(this);
    }

    @Override
    public boolean modificarDAO() {
        FijoDAO fDAO = new FijoSQL();
        return fDAO.modificar(this);
    }

    @Override
    public List<Gasto> obtenerDAO() {
        FijoDAO fDAO = new FijoSQL();
        List<Fijo> fijos = fDAO.obtener(this);
        List<Gasto> gastos = new ArrayList<>(fijos.size());
        gastos.addAll(fijos);
        return gastos;
    }

}
