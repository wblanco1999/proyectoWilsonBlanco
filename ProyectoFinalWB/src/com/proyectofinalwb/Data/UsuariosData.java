/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalwb.Data;

import com.proyectofinalwb.main.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author wilsonblanco
 */
public class UsuariosData {
    public UsuariosData() {
    }
    
    public boolean registrarUsuario(Usuario usuario) throws FileNotFoundException, IOException, ClassNotFoundException {

        File archivo = new File("usuarios.dat");
        List<Usuario> usuarios = new ArrayList<>();
        if(archivo.exists()){
            List<Usuario> usuariosEnArchivo=recuperarUsuarios();
            for (int i = 0; i < usuariosEnArchivo.size(); i++) {
                usuarios.add(usuariosEnArchivo.get(i));
            }
        }
        
        usuarios.add(usuario);
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(archivo));
        output.writeUnshared(usuarios);
        output.close();
        JOptionPane.showMessageDialog(null, "Usuario " + usuario.getUsuario()+ " registrado exitosamete.");
        return false;
    }
    public void iniciarSesion(String usuario, String passwd)throws FileNotFoundException, IOException, ClassNotFoundException {
        List<Usuario> usuarios = new ArrayList<>();
        try{
            boolean encontrado = false;
            usuarios = recuperarUsuarios();
            for(int i = 0; i < usuarios.size(); i++){
                if(usuario.equals(usuarios.get(i).getUsuario()) && passwd.equals(usuarios.get(i).getPasswd())){
                    JOptionPane.showMessageDialog(null, "Bienvenido "+usuarios.get(i).getUsuario());
                    encontrado = true;
                }
            }
            if(!encontrado){
                String texto = "No se ha encontrado ningún usuario";
            }
            
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Por favor digite un usuario y contraseña");
        }
        
    }
    public List<Usuario> recuperarUsuarios() throws FileNotFoundException, IOException, ClassNotFoundException {
        File archivo = new File("usuarios.dat");
        List<Usuario> usuarios = new ArrayList<>();
        if (archivo.exists()) {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(archivo));
            Object aux = input.readObject();
            usuarios = (List<Usuario>) aux;
            input.close();
            return usuarios;
        }

        return null;
    }
}
