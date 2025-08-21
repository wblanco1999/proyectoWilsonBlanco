/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.Apache_derby;

import com.mycompany.Apache_derby.GUI.Cliente;
import com.mycompany.Apache_derby.GUI.Servidor;
import com.mycompany.Apache_derby.business.Conexion;

/**
 *
 * @author wilsonblanco
 */
public class Main {

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        Servidor servidor = new Servidor();
        servidor.setVisible(true);
        cliente.setVisible(true);
    }
    

}
