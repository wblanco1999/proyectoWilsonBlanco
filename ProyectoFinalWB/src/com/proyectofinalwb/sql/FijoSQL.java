/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalwb.sql;

import com.proyectofinalwb.Data.Conexion;
import com.proyectofinalwb.dao.FijoDAO;
import com.proyectofinalwb.enums.Periocidad;
import com.proyectofinalwb.enums.Prioridad;
import com.proyectofinalwb.main.Fijo;
import com.proyectofinalwb.main.Gasto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FijoSQL implements FijoDAO {

    @Override
    public boolean insertar(Fijo f) {
        String insert = "INSERT INTO Fijo (ID, PresupuestoID, Nombre, Monto, Periocidad, Caducidad, Plazo, Prioridad) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection con = Conexion.conexion();
            PreparedStatement st = con.prepareStatement(insert);
            st.setString(1, f.getId());
            st.setString(2, f.getPresupuestoId());
            st.setString(3, f.getNombre());
            st.setDouble(4, f.getMonto());
            st.setString(5, f.getPeriocidad().name());
            st.setBoolean(6, f.isCaducidad());
            st.setInt(7, f.getPlazo());
            st.setString(8, f.getPrioridad().name());
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar gasto fijo: " + e.getMessage() + " | SQLState: " + e.getSQLState());
            return false;
        }
    }

    @Override
    public boolean modificar(Fijo f) {
        String modificar = "UPDATE Fijo SET PresupuestoID = ?, Nombre = ?, Monto = ?, Periocidad = ?, Caducidad = ?, Plazo = ?, Prioridad = ? WHERE ID = ?";
        try {
            Connection con = Conexion.conexion();
            PreparedStatement st = con.prepareStatement(modificar);
            st.setString(1, f.getPresupuestoId());
            st.setString(2, f.getNombre());
            st.setDouble(3, f.getMonto());
            st.setString(4, f.getPeriocidad().name());
            st.setBoolean(5, f.isCaducidad());
            st.setInt(6, f.getPlazo());
            st.setString(7, f.getPrioridad().name());
            st.setString(8, f.getId());
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al modificar gasto fijo: " + e.getMessage() + " | SQLState: " + e.getSQLState());
            return false;
        }
    }

    @Override
    public boolean eliminar(Fijo f) {
        String eliminar = "DELETE FROM Fijo WHERE ID = ?";
        try {
            Connection con = Conexion.conexion();
            PreparedStatement st = con.prepareStatement(eliminar);
            st.setString(1, f.getId());
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar gasto fijo: " + e.getMessage() + " | SQLState: " + e.getSQLState());
            return false;
        }
    }
    @Override
    public List<Fijo> obtener(Fijo f) {
        String obtener = "SELECT * FROM Fijo WHERE PresupuestoID = ?";
        List<Fijo> fijos = new ArrayList<>();
        try {
            Connection con = Conexion.conexion();
            PreparedStatement st = con.prepareStatement(obtener);
            st.setString(1, f.getPresupuestoId());
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Fijo fijo = new Fijo(
                        rs.getBoolean("Caducidad"),
                        rs.getInt("Plazo"),
                        Prioridad.valueOf(rs.getString("Prioridad")),
                        rs.getString("PresupuestoID"),
                        rs.getString("Nombre"),
                        rs.getDouble("Monto"),
                        Periocidad.valueOf(rs.getString("Periocidad"))
                );
                fijo.setId(rs.getString("ID"));
                fijos.add(fijo);
            }

            return fijos;
        } catch (SQLException e) {
            System.out.println("Error al obtener gasto fijo: " + e.getMessage() + " | SQLState: " + e.getSQLState());
            return null;
        }
    }

}
