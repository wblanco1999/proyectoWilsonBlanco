/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estudiocasowilsonblanco;

import java.io.Serializable;

/**
 *
 * @author wilsonblanco
 */
public class Termino implements Serializable{
    private String palabra;
    private String concepto;

    public Termino(String palabra, String concepto) {
        this.palabra = palabra;
        this.concepto = concepto;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
    
}
