/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalwb.sql;

import com.proyectofinalwb.Data.Conexion;
import com.proyectofinalwb.dao.VariableDAO;
import com.proyectofinalwb.enums.Periocidad;
import com.proyectofinalwb.enums.Prioridad;
import com.proyectofinalwb.main.Variable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VariableSQL implements VariableDAO {

    @Override
    public boolean insertar(Variable v) {
        String insert = "INSERT INTO Variable (ID, PresupuestoID, Nombre, Monto, Periocidad, PresupuestoMaximo, Prioridad, TemporadaAlta) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection con = Conexion.conexion();
            PreparedStatement st = con.prepareStatement(insert);
            st.setString(1, v.getId());
            st.setString(2, v.getPresupuestoId());
            st.setString(3, v.getNombre());
            st.setDouble(4, v.getMonto());
            st.setString(5, v.getPeriocidad().name());
            st.setDouble(6, v.getPresupuestoMax());
            st.setString(7, v.getPrioridad().name());
            st.setBoolean(8, v.isTemporadaAlta());
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar gasto variable: " + e.getMessage() + " | SQLState: " + e.getSQLState());
            return false;
        }
    }

    @Override
    public boolean modificar(Variable v) {
        String update = "UPDATE Variable SET PresupuestoID = ?, Nombre = ?, Monto = ?, Periocidad = ?, PresupuestoMaximo = ?, Prioridad = ?, TemporadaAlta = ? WHERE ID = ?";
        try {
            Connection con = Conexion.conexion();
            PreparedStatement st = con.prepareStatement(update);
            st.setString(1, v.getPresupuestoId());
            st.setString(2, v.getNombre());
            st.setDouble(3, v.getMonto());
            st.setString(4, v.getPeriocidad().name());
            st.setDouble(5, v.getPresupuestoMax());
            st.setString(6, v.getPrioridad().name());
            st.setBoolean(7, v.isTemporadaAlta());
            st.setString(8, v.getId());
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al modificar gasto variable: " + e.getMessage() + " | SQLState: " + e.getSQLState());
            return false;
        }
    }

    @Override
    public boolean eliminar(Variable v) {
        String delete = "DELETE FROM Variable WHERE ID = ?";
        try {
            Connection con = Conexion.conexion();
            PreparedStatement st = con.prepareStatement(delete);
            st.setString(1, v.getId());
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar gasto variable: " + e.getMessage() + " | SQLState: " + e.getSQLState());
            return false;
        }
    }

    @Override
    public List<Variable> obtener(Variable v) {
        String query = "SELECT * FROM Variable WHERE PresupuestoID = ?";
        List<Variable> variables = new ArrayList<>();
        try {
            Connection con = Conexion.conexion();
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, v.getPresupuestoId());
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Variable var = new Variable(
                        rs.getDouble("PresupuestoMaximo"),
                        Prioridad.valueOf(rs.getString("Prioridad")), 
                        rs.getBoolean("TemporadaAlta"), 
                        rs.getString("Nombre"),
                        rs.getDouble("Monto"), 
                        Periocidad.valueOf(rs.getString("Periocidad")), 
                        rs.getString("PresupuestoID")
                );
                var.setId(rs.getString("ID"));
                variables.add(var);
            }

            return variables;
        } catch (SQLException e) {
            System.out.println("Error al obtener gasto variable: " + e.getMessage() + " | SQLState: " + e.getSQLState());
            return null;
        }
    }

}
