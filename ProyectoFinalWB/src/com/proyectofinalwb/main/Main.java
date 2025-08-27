/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.proyectofinalwb.main;

import com.proyectofinalwb.GUI.vInicio;
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
        try {
            vInicio vi = new vInicio();
            vServer vs = new vServer();
            vi.setVisible(true);
            vs.setVisible(true);
        } catch (Exception e) {

        }

    }

}
