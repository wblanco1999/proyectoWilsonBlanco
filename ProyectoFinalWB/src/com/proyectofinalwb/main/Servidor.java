/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalwb.main;

import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JTextArea;

/**
 *
 * @author wilsonblanco
 */
public class Servidor extends Thread {

    private final int PUERTO = 9997;
    private JTextArea bitacora;

    public Servidor(JTextArea bitacora) {
        this.bitacora = bitacora;
    }

    @Override
    public void run() {
        bitacora.append("Iniciando servidor...");
        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            bitacora.append("\nIniciado exitosamente.");

            while (true) {
                Socket vCliente = serverSocket.accept();
                bitacora.append("\nNuevo cliente conectado...");
                new MultiCliente(vCliente, bitacora).start();
            }

        } catch (Exception ex) {
            bitacora.append("\nHa ocurrido un error: " + ex.getMessage());
        }

    }
}
