/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalwb.main;

import com.proyectofinalwb.dao.PresupuestoDAO;
import com.proyectofinalwb.sql.PresupuestoSQL;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements Serializable {

    private String username;
    private String passwd;
    private String id;
    private List<Presupuesto> presupuestos;

    public Usuario(String usuario, String passwd) {
        this.username = usuario;
        this.passwd = passwd;
        this.id = ID.agregarID();
        this.presupuestos = new ArrayList<>();
    }

    public Usuario(String id) {
        this.id = id;
    }

    public List<Presupuesto> getPresupuestos() {
        return presupuestos;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void agregarPresupuesto(Presupuesto p) {
        presupuestos.add(p);
    }

    public List<Presupuesto> obtenerPresupuestos(Presupuesto p) {
        PresupuestoDAO dao = new PresupuestoSQL();
        this.presupuestos = dao.obtener(p);
        return this.presupuestos;
    }

    public boolean eliminarPresupuesto(Presupuesto p) {
        PresupuestoDAO dao = new PresupuestoSQL();
        return dao.eliminar(p);
    }

    public boolean insertarPresupuesto(Presupuesto p) {
        PresupuestoDAO dao = new PresupuestoSQL();
        return dao.insertar(p);
    }

    public boolean modificarPresupuesto(Presupuesto p) {
        PresupuestoDAO dao = new PresupuestoSQL();
        return dao.modificar(p);
    }
    

}