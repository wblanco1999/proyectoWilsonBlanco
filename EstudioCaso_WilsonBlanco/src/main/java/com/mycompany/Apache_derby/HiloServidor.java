/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Apache_derby;

import com.mycompany.Apache_derby.data.DerbyCrud;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JTextArea;

/**
 *
 * @author wilsonblanco
 */
public class HiloServidor extends Thread {

    private final int PUERTO = 9997;
    private JTextArea bitacora;
    DerbyCrud crud;

    public HiloServidor(JTextArea bitacora) {
        this.bitacora = bitacora;
        this.crud = new DerbyCrud(this.bitacora);
    }
    
    
    
    @Override
    public void run() {
        try {
            bitacora.append("\nInicializando servidor...");
            ServerSocket sv = new ServerSocket(PUERTO);

            while (true) {
                Socket cliente = sv.accept();
                crud.crearTabla();
                bitacora.append("\nNueva conexión recibida desde " + cliente.getInetAddress());
                confirmarProceso(cliente, EjecutarInsert(recibirTermino(cliente)));
            }
        } catch (Exception e) {
            System.out.println("Error de servidor");
            this.bitacora.append("\nError en el servidor.");
        }
    }

    public boolean EjecutarInsert(Termino termino) {
        try {
            return crud.insertarTermino(termino);

        } catch (Exception ex) {
            System.out.println("Error al ejecutar insert");
            this.bitacora.append("\nError al ejecutar insert.");
            return false;
        }

    }

    public Termino recibirTermino(Socket cliente) {
        Termino termino = new Termino();
        try {
            ObjectInputStream vInput = new ObjectInputStream(cliente.getInputStream());
            termino = (Termino) vInput.readObject();
            this.bitacora.append("\nTermino recibido"
                    + "\nPalabra: "+termino.getPalabra()
                    + "\nConcepto: "+termino.getConcepto());
            
            
        } catch (Exception ex) {
            System.out.println("Error al recibir termino");
            this.bitacora.append("\nError al recibir termino.");
        }
        return termino;
    }
    public void confirmarProceso(Socket cliente, boolean bol){
        try {
            DataOutputStream output = new DataOutputStream(cliente.getOutputStream());
            if(bol){
                output.writeUTF("Termino guardado exitosamente!");
            }
            else{
                output.writeUTF("No se guardo la palabra.\nNo se puede guardar la misma palabra dos veces. ");
            }
            
        } catch (Exception e) {
        }
    }

}
