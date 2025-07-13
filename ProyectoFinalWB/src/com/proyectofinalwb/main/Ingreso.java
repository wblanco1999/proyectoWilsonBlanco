/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalwb.main;

/**
 *
 * @author wilsonblanco
 */
public class Ingreso {
    private String id;
    private String tipoDeIngreso;
    private final double CCSS = 0.108;
    private double impuestoDeRenta;
    private double salarioBruto;
    private double totalImpuesto;
    private double salarioNeto;

    public Ingreso(String id, String tipoDeIngreso, double salarioBruto) {
        this.id = id;
        this.tipoDeIngreso = tipoDeIngreso;
        this.salarioBruto = salarioBruto;
        calcularImpuestos(salarioBruto);
        calcularSalarioNeto(this.totalImpuesto, salarioBruto);
    }
        
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoDeIngreso() {
        return tipoDeIngreso;
    }

    public void setTipoDeIngreso(String tipoDeIngreso) {
        this.tipoDeIngreso = tipoDeIngreso;
    }

    public double getImpuestoDeRenta() {
        return impuestoDeRenta;
    }

    public void setImpuestoDeRenta(double impuestoDeRenta) {
        this.impuestoDeRenta = impuestoDeRenta;
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public double getTotalImpuesto() {
        return totalImpuesto;
    }

    public void setTotalImpuesto(double totalImpuesto) {
        this.totalImpuesto = totalImpuesto;
    }

    public double getSalarioNeto() {
        return salarioNeto;
    }

    public void setSalarioNeto(double salarioNeto) {
        this.salarioNeto = salarioNeto;
    }
    
    public void calcularImpuestos(double salarioBruto){
        if(salarioBruto > 922000.00){
            setImpuestoDeRenta(0.10);
        }
        else if(salarioBruto > 923000.00){
            setImpuestoDeRenta(0.15);
        }
        else if(salarioBruto > 923000.00){
            setImpuestoDeRenta(0.20);
        }
        else if(salarioBruto > 923000.00){
            setImpuestoDeRenta(0.25);
        }
        else{
            setImpuestoDeRenta(0.0);
        }
        setTotalImpuesto(((this.salarioBruto*getImpuestoDeRenta())+(this.salarioBruto*this.CCSS)));
    }
    public void calcularSalarioNeto(double totalImpuestos, double salarioBruto){
        setSalarioNeto(this.salarioBruto-getTotalImpuesto());
        
    }

    @Override
    public String toString() {
        return "Ingreso{" + "id=" + id + ", tipoDeIngreso=" + tipoDeIngreso + ", totalImpuesto=" + totalImpuesto + ", salarioNeto=" + salarioNeto + '}';
    }
    
}
