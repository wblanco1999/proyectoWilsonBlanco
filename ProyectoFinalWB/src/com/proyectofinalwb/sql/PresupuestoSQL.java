/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalwb.sql;

import com.proyectofinalwb.Data.Conexion;
import com.proyectofinalwb.dao.PresupuestoDAO;
import com.proyectofinalwb.main.Discrecional;
import com.proyectofinalwb.main.Fijo;
import com.proyectofinalwb.main.Ingreso;
import com.proyectofinalwb.main.Presupuesto;
import com.proyectofinalwb.main.Variable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PresupuestoSQL implements PresupuestoDAO {

    @Override
    public boolean insertar(Presupuesto p) {
        String insert = "INSERT INTO Presupuesto (ID, Limite, Meta, UsuarioID) VALUES(?, ?, ?, ?)";
        try {
            Connection con = Conexion.conexion();
            PreparedStatement st = con.prepareStatement(insert);
            st.setString(1, p.getId());
            st.setDouble(2, p.getLimite());
            st.setDouble(3, p.getMeta());
            st.setString(4, p.getUsuarioId());
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar presupuesto: " + e.getMessage() + " | SQLState: " + e.getSQLState());
            return false;
        }
    }

    @Override
    public boolean modificar(Presupuesto p) {
        String modificar = "UPDATE Presupuesto SET Limite = ?, Meta = ?, UsuarioID = ? WHERE ID = ?";
        try (Connection con = Conexion.conexion(); PreparedStatement st = con.prepareStatement(modificar)) {

            st.setDouble(1, p.getLimite());
            st.setDouble(2, p.getMeta());
            st.setString(3, p.getUsuarioId().trim());
            st.setString(4, p.getId().trim());

            int filas = st.executeUpdate();

            if (filas > 0) {
                System.out.println("Presupuesto modificado correctamente. Filas afectadas: " + filas);
                return true;
            } else {
                System.out.println("No se encontró presupuesto con ID = " + p.getId());
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al modificar presupuesto: "
                    + e.getMessage() + " | SQLState: " + e.getSQLState());
            return false;
        }
    }

    @Override
    public boolean eliminar(Presupuesto p) {
        String eliminar = "DELETE FROM Presupuesto WHERE ID = ?";
        try (Connection con = Conexion.conexion(); PreparedStatement st = con.prepareStatement(eliminar)) {

            st.setString(1, p.getId());
            int filas = st.executeUpdate();

            if (filas > 0) {
                System.out.println("Presupuesto eliminado correctamente.");
                return true;
            } else {
                System.out.println("No se encontró presupuesto con ID = " + p.getId());
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar presupuesto: " + e.getMessage() + " | SQLState: " + e.getSQLState());
            return false;
        }
    }

    @Override
    public List<Presupuesto> obtener(Presupuesto p) {
        String obtener = "SELECT * FROM Presupuesto WHERE UsuarioID = ?";
        List<Presupuesto> presupuestos = new ArrayList<>();

        try {
            Connection con = Conexion.conexion();
            PreparedStatement st = con.prepareStatement(obtener);
            st.setString(1, p.getUsuarioId());
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Presupuesto pre = new Presupuesto(
                        rs.getString("ID"),
                        rs.getString("UsuarioID"),
                        rs.getDouble("Limite"),
                        rs.getDouble("Meta")
                );
                pre.obtenerIngresos(new Ingreso(pre.getId()));
                pre.obtenerGastos(new Fijo(pre.getId()));
                pre.obtenerGastos(new Variable(pre.getId()));
                pre.obtenerGastos(new Discrecional(pre.getId()));
                presupuestos.add(pre);
            }

            return presupuestos;
        } catch (SQLException e) {
            System.out.println("Error al obtener presupuesto: " + e.getMessage() + " | SQLState: " + e.getSQLState());
            return null;
        }
    }

    public List<Presupuesto> obtenerPorUsuario(String usuarioId) {
        String sql = "SELECT * FROM Presupuesto WHERE UsuarioID = ?";
        List<Presupuesto> presupuestos = new ArrayList<>();

        try (Connection con = Conexion.conexion(); PreparedStatement st = con.prepareStatement(sql)) {

            st.setString(1, usuarioId);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Presupuesto pre = new Presupuesto(
                        rs.getString("ID"),
                        rs.getString("UsuarioID"),
                        rs.getDouble("Limite"),
                        rs.getDouble("Meta")
                );
                presupuestos.add(pre);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener presupuestos: " + e.getMessage());
        }
        return presupuestos;
    }

}
