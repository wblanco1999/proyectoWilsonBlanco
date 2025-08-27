/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalwb.main;

import com.proyectofinalwb.dao.IngresoDAO;
import com.proyectofinalwb.dao.PresupuestoDAO;
import com.proyectofinalwb.dao.UsuariosDAO;
import com.proyectofinalwb.sql.IngresoSQL;
import com.proyectofinalwb.sql.PresupuestoSQL;
import com.proyectofinalwb.sql.UsuarioSQL;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JTextArea;

/**
 *
 * @author wilsonblanco
 */
public class MultiCliente extends Thread {

    private Socket cliente;
    private JTextArea bitacora;
    boolean bandera = true;

    public MultiCliente(Socket cliente, JTextArea bitacora) {
        this.cliente = cliente;
        this.bitacora = bitacora;
    }

    @Override
    public void run() {
        
        try {

            ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());
            out.flush();
            ObjectInputStream in = new ObjectInputStream(cliente.getInputStream());

            String ubicacion = in.readUTF();
            bitacora.append("\nConexion desde: " + ubicacion);
            while (bandera) {
                this.bitacora.append("\nEscuchando...");
                String opcion = in.readUTF();
                bandera = recibirComando(opcion, in, out);
            }
            bitacora.append("\nSesión con cliente finalizada.");
            cliente.close();
        } catch (Exception ex) {
            bitacora.append("\nError parando el servidor...");
            System.out.println(ex.getMessage() + " & " + ex.getStackTrace());
            bandera = false;
        }
    }

    private void registrar(ObjectInputStream in, ObjectOutputStream out) throws Exception {
        try {
            UsuariosDAO dao = new UsuarioSQL();
            Usuario u = (Usuario) in.readObject();
            boolean confirmar = dao.insertar(u);

            if (confirmar == true) {
                bitacora.append("\nUsuario recibido: " + u.getUsername());
                bitacora.append("\nContraseña recibida");
                bitacora.append("\nUsuario registrado.");
                out.writeUTF("El usuario " + u.getUsername() + " se ha registrado.");
                out.flush();
            } else {
                out.writeUTF("NO");
                out.flush();

            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + e.getStackTrace());
        }

    }

    private void iniciarSesion(ObjectInputStream in, ObjectOutputStream out) throws Exception {
        UsuariosDAO dao = new UsuarioSQL();
        Usuario u = (Usuario) in.readObject();
        try {
            u = dao.obtener(u).get(0);
            if (u != null) {
                out.writeUTF("Bienvenido " + u.getUsername());
                out.flush();
                bitacora.append("\nSesión iniciada por el usuario " + u.getUsername());
                out.writeObject(u);
                out.flush();
            }
        } catch (Exception e) {
            out.writeUTF("");
            out.flush();
            bitacora.append("\nUsuario no encontrado reportando...");

        }
    }
    
    private void insertarIngreso(ObjectInputStream in, ObjectOutputStream out) throws IOException, ClassNotFoundException{
            IngresoDAO dao = new IngresoSQL();
            Ingreso i = (Ingreso) in.readObject();
            try {
            boolean confirmar = dao.insertar(i);
            if(confirmar == true){
                bitacora.append("\nIngreso insertado en tabla");
                out.writeUTF("EXITO");
                out.flush();
            }else{
                bitacora.append("\nError al insertar ingreso en tabla");
                out.writeUTF("");
                out.flush();
            }
        } catch (Exception e) {
            bitacora.append("\nError al insertar ingreso en tabla" + e.getMessage());
            out.writeUTF("ERROR");
            out.flush();
        }
        }
    private void insertarGasto(ObjectInputStream in, ObjectOutputStream out)throws IOException, ClassNotFoundException{
            Presupuesto p = new Presupuesto();
            Gasto f = (Gasto) in.readObject();
            boolean confirmar = p.agregarGastos(f);
            if(confirmar == true){
                out.writeBoolean(true);
                out.flush();
                this.bitacora.append("\nSe ha insertado exitosamente gasto " + f.getNombre());
            }
            else{
                out.writeBoolean(false);
                out.flush();
                this.bitacora.append("\nNo se pudo insertar el gasto");
            }
    }   
    private void insertarPresupuesto(ObjectInputStream in, ObjectOutputStream out)throws IOException, ClassNotFoundException{
            PresupuestoDAO dao = new PresupuestoSQL();
            Presupuesto p = (Presupuesto) in.readObject();
            boolean confirmar = dao.insertar(p);
            if(confirmar){
                out.writeBoolean(true);
                out.flush();
                this.bitacora.append("\nSe ha insertado un presupuesto temportal exitosamente"
                        + "\n" + p.toString());
            }
            else{
                out.writeBoolean(false);
                out.flush();
                this.bitacora.append("\nNo se ha podido insertar este presupuesto");
            }
    }
    private void modificarPresupuesto(ObjectInputStream in, ObjectOutputStream out)throws IOException, ClassNotFoundException{
            PresupuestoDAO dao = new PresupuestoSQL();
            Presupuesto p = (Presupuesto) in.readObject();
            
            this.bitacora.append("\nPresupuesto recibido: "+ p.toString());
            boolean confirmar = dao.modificar(p);
            if(confirmar){
                out.writeBoolean(true);
                out.flush();
                this.bitacora.append("\nSe ha modificado un presupuesto exitosamente");
            }
            else{
                out.writeBoolean(false);
                out.flush();
                this.bitacora.append("\nNo se ha podido insertar este presupuesto");
            }
    }
    
    
    private boolean recibirComando(String comando, ObjectInputStream in, ObjectOutputStream out) throws Exception {
        try {

            switch (comando.toUpperCase()) {
                case "INICIAR" -> {
                    bitacora.append("\nEjecutando iniciar sesión");
                    iniciarSesion(in, out);
                }
                case "REGISTRAR" -> {
                    bitacora.append("\nEjecutando registrar");
                    registrar(in, out);
                }
                case "INGRESO" -> {
                    bitacora.append("\nEjecutando ingreso");
                    insertarIngreso(in, out);
                }
                case "GASTO" -> {
                    bitacora.append("\nEjecutando gasto");
                    insertarGasto(in, out);
                }
                case "PRESUPUESTO" -> {
                    bitacora.append("\nEjecutando presupuesto");
                    insertarPresupuesto(in, out);
                }
                case "PRESUPUESTO-MOD" -> {
                    bitacora.append("\nEjecutando modificar presupuesto");
                    modificarPresupuesto(in, out);
                }
                case "SALIR" -> {
                    bitacora.append("\nCerrando conexión");
                    this.bandera=false;
                }
                default ->
                    out.writeUTF("\nOpción no válida");

            }

        } catch (Exception e) {
            bitacora.append("\nError en cliente: " + e.getMessage());
            return false;
        }
        return true;
    }
}
