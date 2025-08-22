/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.proyectofinalwb.main;

import com.proyectofinalwb.GUI.vPrincipal;
import com.proyectofinalwb.GUI.vServer;

/**
 *
 * @author wilsonblanco
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        vPrincipal p = new vPrincipal();
        vServer vs = new vServer();
        vs.setVisible(true);
        p.setVisible(true);
    }
    
}
