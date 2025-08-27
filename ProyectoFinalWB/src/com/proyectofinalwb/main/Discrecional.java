/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalwb.main;

import com.proyectofinalwb.dao.DiscrecionalDAO;
import com.proyectofinalwb.enums.Periocidad;
import com.proyectofinalwb.sql.DiscrecionalSQL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wilsonblanco
 */
public class Discrecional extends Gasto {

    private boolean impulso;
    private String frecuencia;
    private String descripcion;

    public Discrecional() {
    }

    public Discrecional(String presupuestoId) {
        super(presupuestoId);
    }

    public Discrecional(boolean impulso, String frecuencia, String descripcion, String nombre, double monto, Periocidad periocidad, String presupuestoId) {
        super(nombre, monto, periocidad, presupuestoId);
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

    @Override
    public String tipoDeGasto() {
        return "Discrecional";
    }

    @Override
    public boolean insertarDAO() {
        DiscrecionalDAO dao = new DiscrecionalSQL();
        return dao.insertar(this);
    }

    @Override
    public boolean eliminarDAO() {
        DiscrecionalDAO dao = new DiscrecionalSQL();
        return dao.eliminar(this);
    }

    @Override
    public boolean modificarDAO() {
        DiscrecionalDAO dao = new DiscrecionalSQL();
        return dao.modificar(this);
    }

    @Override
    public List<Gasto> obtenerDAO() {
        DiscrecionalDAO dao = new DiscrecionalSQL();
        List<Discrecional> fijos = dao.obtener(this);
        List<Gasto> gastos = new ArrayList<>(fijos.size());
        gastos.addAll(fijos);
        
        return gastos;
    }

}
