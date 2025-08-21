/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalwb.main;

import com.proyectofinalwb.Data.UsuariosData;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;

/**
 *
 * @author wilsonblanco
 */
public class MultiCliente extends Thread{
    private Socket cliente;
    private JTextArea bitacora;

    public MultiCliente(Socket cliente, JTextArea bitacora) {
        this.cliente = cliente;
        this.bitacora = bitacora;
    }

    @Override
    public void run() {
        boolean bandera = true;
        try {
            DataInputStream vInput = new DataInputStream(cliente.getInputStream());
            DataOutputStream vOutput = new DataOutputStream(cliente.getOutputStream());
            String ubicacion = vInput.readUTF();
            bitacora.append("\nConexion desde: " + ubicacion);

            
            while (bandera) {

                String opcion = vInput.readUTF();
                bandera = recibirComando(opcion, vInput, vOutput);
            }
            bitacora.append("\nSesión con cliente finalizada.");
            cliente.close();
        } catch (Exception ex) {
            bitacora.append("\nError parando el servidor");
            bandera = false;
        }
    }

    private void registrar(DataInputStream input, DataOutputStream output) throws Exception {
        String usuario = input.readUTF();
        bitacora.append("\nUsuario recibido: " + usuario);

        String passwd = input.readUTF();
        bitacora.append("\nContraseña recibida");

        String correo = input.readUTF();
        bitacora.append("\nCorreo recibido: " + correo);
        bitacora.append("\nUsuario registrado.");
        UsuariosData r = new UsuariosData();
        r.registrarUsuario(new Usuario(usuario, correo, passwd));
        output.writeUTF("El usuario " + usuario + " se ha registrado.");
    }

    private void iniciarSesion(DataInputStream input, DataOutputStream output) throws Exception {
        String usuario = input.readUTF();
        String passwd = input.readUTF();

        UsuariosData ud = new UsuariosData();
        List<Usuario> usuarios = new ArrayList<>(ud.recuperarUsuarios());

        boolean ctrl = false;
        for (Usuario u : usuarios) {
            if (u.getUsuario().equals(usuario) && u.getPasswd().equals(passwd)) {
                output.writeUTF("Bienvenido " + u.getUsuario());
                bitacora.append("\nSesión iniciada por el usuario " + u.getUsuario());
                ctrl = true;
                break;
            }
        }

        if (!ctrl) {
            output.writeUTF("No se ha encontrado ningún usuario.");
            bitacora.append("\nUsuario no encontrado reportando...");
        }
    }

//    private void obtenerRecord(DataInputStream vInput, DataOutputStream vOutput) throws IOException {
//        try {
//            ArrayList<String> array = new ArrayList<>();
//            MysqlCRUD sql = new MysqlCRUD();
//            String categoria = vInput.readUTF();
//            String nombre = vInput.readUTF();
//            array = sql.conseguirRegistro(categoria, nombre);
//            vOutput.writeUTF(array.get(0));
//            vOutput.writeUTF(array.get(1));
//            vOutput.writeUTF(array.get(2));
//            vOutput.writeUTF(array.get(3));
//        } catch (Exception ex) {
//            bitacora.append("\nError al obtener record " + ex.getMessage());
//            vOutput.writeUTF("");
//            vOutput.writeUTF("");
//            vOutput.writeUTF("");
//            vOutput.writeUTF("");
//        }
//
//    }

    private boolean recibirComando(String comando, DataInputStream vInput, DataOutputStream vOutput) throws Exception {
        try {

            switch (comando.toUpperCase()) {
                case "INICIAR" -> {
                    bitacora.append("\nEjecutando iniciar sesión");
                    iniciarSesion(vInput, vOutput);

                }
                case "REGISTRAR" -> {
                    bitacora.append("\nEjecutando registrar");
                    registrar(vInput, vOutput);
                }
                case "BUSCAR" -> {
//                    bitacora.append("\nEjecutando BUSCAR");
//                    obtenerRecord(vInput, vOutput);
                }
                default ->
                    vOutput.writeUTF("\nOpción no válida");
            }

        } catch (Exception e) {
            bitacora.append("\nError en cliente: " + e.getMessage());
            return false;
        }
        return true;
    }
}
