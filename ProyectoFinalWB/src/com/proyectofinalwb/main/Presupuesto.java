/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalwb.main;

import com.proyectofinalwb.dao.IngresoDAO;
import com.proyectofinalwb.sql.IngresoSQL;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Presupuesto implements Serializable {

    private List<Ingreso> ingresos;
    private List<Gasto> gastos;
    private String usuarioId;
    private double limite;
    private double meta;
    private String id;

    // Para crear nuevo (cliente)
    public Presupuesto(String usuarioId) {
        this.usuarioId = usuarioId;
        this.limite = 0;
        this.meta = 0;
        this.id = ID.agregarID();  // solo al crear
        this.ingresos = new ArrayList<>();
        this.gastos = new ArrayList<>();
    }

// Para cargar desde BD
    public Presupuesto(String id, String usuarioId, double limite, double meta) {
        this.id = id;                  // ID real de la BD
        this.usuarioId = usuarioId;
        this.limite = limite;
        this.meta = meta;
        this.ingresos = new ArrayList<>();
        this.gastos = new ArrayList<>();
    }
    

// Constructor vacío para setters y getters
    public Presupuesto() {
        this.ingresos = new ArrayList<>();
        this.gastos = new ArrayList<>();
    }

    public List<Gasto> getGastos() {
        return gastos;
    }

    public void setGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getMeta() {
        return meta;
    }

    public void setMeta(double meta) {
        this.meta = meta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public List<Ingreso> getIngresos() {
        return ingresos;
    }

    public void setIngresos(List<Ingreso> ingresos) {
        this.ingresos = ingresos;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public boolean agregarIngreso(Ingreso i) {
        IngresoDAO dao = new IngresoSQL();
        return dao.insertar(i);
    }

    public boolean eliminarIngreso(Ingreso i) {
        IngresoDAO dao = new IngresoSQL();
        return dao.eliminar(i);
    }

    public boolean modificarIngreso(Ingreso i) {
        IngresoDAO dao = new IngresoSQL();
        return dao.modificar(i);
    }

    public void obtenerIngresos(Ingreso i) {
        IngresoDAO dao = new IngresoSQL();
        this.ingresos = dao.obtener(i);
    }

    public boolean agregarGastos(Gasto g) {
        return g.insertarDAO();

    }

    public boolean eliminarGastos(Gasto g) {
        return g.eliminarDAO();
    }

    public boolean modificarGasto(Gasto g) {
        return g.modificarDAO();
    }

     public void obtenerGastos(Gasto g) {
        List<Gasto> gastosLista = g.obtenerDAO();
        this.gastos.addAll(gastosLista);
    }

    public double totalIngresos(List<Ingreso> ingresos) {
        int total = 0;
        for (int i = 0; i < ingresos.size(); i++) {
            total += ingresos.get(i).getSalarioNeto();
            System.out.println("\nSalario neto " + i +" "+ ingresos.get(i).getSalarioNeto());
        }
        System.out.println(total + "\nIngresos");
        return total;

    }

    public double totalGastos(List<Gasto> gastos) {
        int total = 0;
        for (int i = 0; i < gastos.size(); i++) {
            total += gastos.get(i).getMonto();
            System.out.println("\nGastos "+ i +" "+ gastos.get(i).getMonto());
        }
        System.out.println(total + "\ngastos");
        return total;
    }

    public boolean comprobarMeta(List<Ingreso> ingresos, List<Gasto> gastos) {
        double libre = (totalIngresos(ingresos) - totalGastos(gastos));
        return libre >= this.meta;

    }

    public boolean comprobarLimite(List<Ingreso> ingresos, List<Gasto> gastos) {
        return this.limite > totalGastos(gastos);

    }

    public double totalLibre() {
        return (totalIngresos(this.ingresos) - totalGastos(this.gastos));
    }

    @Override
    public String toString() {
        return "Presupuesto{" + "usuarioId=" + usuarioId + ", limite=" + limite + ", meta=" + meta + ", id=" + id + '}';
    }
    
    
}
