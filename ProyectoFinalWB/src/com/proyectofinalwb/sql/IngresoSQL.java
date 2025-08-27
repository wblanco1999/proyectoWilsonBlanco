/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalwb.sql;

import com.proyectofinalwb.Data.Conexion;
import com.proyectofinalwb.dao.IngresoDAO;
import com.proyectofinalwb.main.Ingreso;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IngresoSQL implements IngresoDAO {

    @Override
    public boolean insertar(Ingreso i) {
        String insert = "INSERT INTO Ingreso (ID, TipoDeIngreso, ImpuestoRenta, Salario, TotalImpuestos, SalarioNeto, PresupuestoID) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection con = Conexion.conexion();
            PreparedStatement st = con.prepareStatement(insert);
            st.setString(1, i.getId());
            st.setString(2, i.getTipoDeIngreso());
            st.setDouble(3, i.getImpuestoDeRenta());
            st.setDouble(4, i.getSalarioBruto());
            st.setDouble(5, i.getTotalImpuesto());
            st.setDouble(6, i.getSalarioNeto());
            st.setString(7, i.getPresupuestoId());
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar ingreso: " + e.getMessage() + " | SQLState: " + e.getSQLState());
            return false;
        }
    }

    @Override
    public boolean modificar(Ingreso i) {
        String modificar = "UPDATE Ingreso SET TipoDeIngreso = ?, ImpuestoRenta = ?, Salario = ?, TotalImpuestos = ?, SalarioNeto = ?, PresupuestoID = ? WHERE ID = ?";
        try {
            Connection con = Conexion.conexion();
            PreparedStatement st = con.prepareStatement(modificar);
            st.setString(1, i.getTipoDeIngreso());
            st.setDouble(2, i.getImpuestoDeRenta());
            st.setDouble(3, i.getSalarioBruto());
            st.setDouble(4, i.getTotalImpuesto());
            st.setDouble(5, i.getSalarioNeto());
            st.setString(6, i.getPresupuestoId());
            st.setString(7, i.getId());
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al modificar ingreso: " + e.getMessage() + " | SQLState: " + e.getSQLState());
            return false;
        }
    }

    @Override
    public boolean eliminar(Ingreso i) {
        String eliminar = "DELETE FROM Ingreso WHERE ID = ?";
        try {
            Connection con = Conexion.conexion();
            PreparedStatement st = con.prepareStatement(eliminar);
            st.setString(1, i.getId());
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar ingreso: " + e.getMessage() + " | SQLState: " + e.getSQLState());
            return false;
        }
    }

    @Override
public List<Ingreso> obtener(Ingreso i) {
    String obtener = "SELECT * FROM Ingreso WHERE PresupuestoID = ?";
    List<Ingreso> ingresos = new ArrayList<>();
    try {
        Connection con = Conexion.conexion();
        PreparedStatement st = con.prepareStatement(obtener);
        st.setString(1, i.getPresupuestoId());
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            Ingreso ingreso = new Ingreso(
                rs.getString("ID"),
                rs.getString("TipoDeIngreso"),
                rs.getDouble("Salario"),       
                rs.getString("PresupuestoID")
            );
            ingreso.setImpuestoDeRenta(rs.getDouble("ImpuestoRenta"));
            ingreso.setTotalImpuesto(rs.getDouble("TotalImpuestos"));
            ingreso.setSalarioNeto(rs.getDouble("SalarioNeto"));

            ingresos.add(ingreso);
        }
        return ingresos;
    } catch (SQLException e) {
        System.out.println("Error al obtener ingreso: " + e.getMessage() + " | SQLState: " + e.getSQLState());
        return null;
    }
}

}
