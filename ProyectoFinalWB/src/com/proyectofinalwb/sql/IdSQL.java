/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalwb.sql;
import com.proyectofinalwb.Data.Conexion;
import com.proyectofinalwb.enums.Periocidad;
import com.proyectofinalwb.enums.Prioridad;
import com.proyectofinalwb.main.Fijo;
import com.proyectofinalwb.main.ID;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author wilsonblanco
 */
public class IdSQL {
    public String insertar(String id) {
        String insert = "INSERT INTO ID VALUES (?)";
        try {
            Connection con = Conexion.conexion();
            PreparedStatement st = con.prepareStatement(insert); 
            st.setString(1, id);
            st.executeUpdate();
            return id;
        } catch (SQLException e) {
            System.out.println("Error al insertar ID " + e.getMessage() + " | SQLState: " + e.getSQLState());
            return null;
        }
    }

    public void eliminar(String i) {
        String eliminar = "DELETE FROM ID WHERE ID = ?";
        try {
            Connection con = Conexion.conexion();
            PreparedStatement st = con.prepareStatement(eliminar);
//            st.setString(1, .getId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar ID: " + e.getMessage() + " | SQLState: " + e.getSQLState());
        }
    }
}
