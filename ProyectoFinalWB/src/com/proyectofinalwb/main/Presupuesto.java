/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalwb.main;

import java.util.ArrayList;

/**
 *
 * @author wilsonblanco
 */
public class Presupuesto {
    private ArrayList<Ingreso> ingresos;
    private ArrayList<Gasto> gastos;
    private double limite;
    private double meta;

    public Presupuesto(double limite, double meta) {
        this.ingresos = new ArrayList<>();
        this.gastos = new ArrayList<>();
        this.limite = limite;
        this.meta = meta;
    }
    
    public void agregarIngreso(String id, String tipoDeIngreso, double salario){      
        this.ingresos.add(new Ingreso(id,tipoDeIngreso, salario));
    }
    
    public void eliminarIngreso(String id){
        
    }
    
}
