/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinalwb;

/**
 *
 * @author wilsonblanco
 */
public class Ingreso {
    private String id;
    private String tipoDeIngreso;
    private final double CCSS = 0.108;
    private int impuestoDeRenta;
    private double salarioBruto;
    private double totalImpuesto;
    private double salarioNeto;

    public Ingreso(String id, String tipoDeIngreso, double salarioBruto) {
        this.id = id;
        this.tipoDeIngreso = tipoDeIngreso;
        this.salarioBruto = salarioBruto;
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

    public int getImpuestoDeRenta() {
        return impuestoDeRenta;
    }

    public void setImpuestoDeRenta(int impuestoDeRenta) {
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
    
}
