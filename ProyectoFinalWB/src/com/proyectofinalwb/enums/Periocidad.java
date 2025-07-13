/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.proyectofinalwb.enums;

/**
 *
 * @author wilsonblanco
 */
public enum Periocidad {
    DIARIA(1),
    SEMANAL(7),
    QUINCENAL(15),
    MENSUAL(30),
    ANUAL(365),
    SEMESTRE(193);
    
    private final int diasValor;
    
    Periocidad(int dias){
    this.diasValor = dias;

    }
    public int getDias(){
        return diasValor;
    }
}
