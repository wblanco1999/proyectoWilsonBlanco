/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalwb.main;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author wilsonblanco
 */
public class Usuario implements Serializable{
    private String usuario;
    private String passwd;
    private String correoElectronico;
    private ArrayList<Transaccion> transacciones;

    public Usuario(String usuario, String passwd, String correoElectronico) {
        this.usuario = usuario;
        this.passwd = passwd;
        this.correoElectronico = correoElectronico;
        this.transacciones = new ArrayList<>();
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    
    public void agregarTransaccion(String id, boolean egreso, double monto ){
        this.transacciones.add(new Transaccion(id, egreso, monto));
    }
    
    public String verTransacciones(){
        String lista = "Transacciones hechas";
        for(int i = 0; i < this.transacciones.size(); i++){
            lista+= transacciones.get(i).toString();
            
        }
        return lista;
    }
}
