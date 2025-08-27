/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalwb.sql;

import com.proyectofinalwb.Data.Conexion;
import com.proyectofinalwb.dao.UsuariosDAO;
import com.proyectofinalwb.main.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioSQL implements UsuariosDAO {

    @Override
    public boolean insertar(Usuario u) {
        String insert = "INSERT INTO Usuario VALUES(?, ?, ?)";
        try {
            Connection con = Conexion.conexion();
            PreparedStatement st = con.prepareStatement(insert);
            st.setString(1, u.getId());
            st.setString(2, u.getUsername());
            st.setString(3, u.getPasswd());
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar " + e.getMessage() + " and " + e.getSQLState());
            return false;
        }
    }

    @Override
    public boolean modificar(Usuario u) {
        String modificar = "UPDATE Usuario SET Usuario = ?, Passwd = ? WHERE ID = ?";
        try {
            Connection con = Conexion.conexion();
            PreparedStatement st = con.prepareStatement(modificar);
            st.setString(1, u.getUsername());
            st.setString(2, u.getPasswd());
            st.setString(3, u.getId());
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al modificar " + e.getMessage() + " and " + e.getSQLState());
            return false;
        }
    }

    @Override
    public boolean eliminar(Usuario u) {
        String deletear = "DELETE FROM Usuario WHERE ID = ?";
        try {
            Connection con = Conexion.conexion();
            PreparedStatement st = con.prepareStatement(deletear);
            st.setString(1, u.getId());
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar " + e.getMessage() + " and " + e.getSQLState());
            return false;
        }
    }

    @Override
    public List<Usuario> obtener(Usuario u) {
        String obtener = "SELECT * FROM Usuario WHERE username = ? AND passwd = ?";
        List<Usuario> usuarios = new ArrayList<>();
        try {
            Connection con = Conexion.conexion();
            PreparedStatement st = con.prepareStatement(obtener);
            st.setString(1, u.getUsername());
            st.setString(2, u.getPasswd());
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                Usuario ubd = new Usuario(
                        rs.getString("id")
                );
                ubd.setUsername(rs.getString("username"));
                ubd.setPasswd(rs.getString("passwd"));
                usuarios.add(ubd);
            }

            return usuarios;
        } catch (SQLException e) {
            System.out.println("Error en obtener: " + e.getMessage());
            return null;
        }
    }

}
