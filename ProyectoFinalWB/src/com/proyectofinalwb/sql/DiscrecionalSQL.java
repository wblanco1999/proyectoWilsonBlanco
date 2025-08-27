/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalwb.sql;

import com.proyectofinalwb.Data.Conexion;
import com.proyectofinalwb.dao.DiscrecionalDAO;
import com.proyectofinalwb.enums.Periocidad;
import com.proyectofinalwb.main.Discrecional;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DiscrecionalSQL implements DiscrecionalDAO {

    @Override
    public boolean insertar(Discrecional d) {
        String insert = "INSERT INTO Discrecional (ID, PresupuestoID, Nombre, Monto, Periocidad, Impulso, Frecuencia, Descripcion) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection con = Conexion.conexion();
            PreparedStatement st = con.prepareStatement(insert);
            st.setString(1, d.getId());
            st.setString(2, d.getPresupuestoId());
            st.setString(3, d.getNombre());
            st.setDouble(4, d.getMonto());
            st.setString(5, d.getPeriocidad().name());
            st.setBoolean(6, d.isImpulso());
            st.setString(7, d.getFrecuencia());
            st.setString(8, d.getDescripcion());
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar gasto discrecional: " + e.getMessage() + " | SQLState: " + e.getSQLState());
            return false;
        }
    }

    @Override
    public boolean modificar(Discrecional d) {
        String update = "UPDATE Discrecional SET PresupuestoID = ?, Nombre = ?, Monto = ?, Periocidad = ?, Impulso = ?, Frecuencia = ?, Descripcion = ? WHERE ID = ?";
        try {
            Connection con = Conexion.conexion();
            PreparedStatement st = con.prepareStatement(update);
            st.setString(1, d.getPresupuestoId());
            st.setString(2, d.getNombre());
            st.setDouble(3, d.getMonto());
            st.setString(4, d.getPeriocidad().name());
            st.setBoolean(5, d.isImpulso());
            st.setString(6, d.getFrecuencia());
            st.setString(7, d.getDescripcion());
            st.setString(8, d.getId());
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al modificar gasto discrecional: " + e.getMessage() + " | SQLState: " + e.getSQLState());
            return false;
        }
    }

    @Override
    public boolean eliminar(Discrecional d) {
        String delete = "DELETE FROM Discrecional WHERE ID = ?";
        try {
            Connection con = Conexion.conexion();
            PreparedStatement st = con.prepareStatement(delete);
            st.setString(1, d.getId());
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar gasto discrecional: " + e.getMessage() + " | SQLState: " + e.getSQLState());
            return false;
        }
    }
    @Override
    public List<Discrecional> obtener(Discrecional d) {
    String query = "SELECT * FROM Discrecional WHERE PresupuestoID = ?";
    List<Discrecional> discrecionales = new ArrayList<>();

    try {
        Connection con = Conexion.conexion();
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1, d.getPresupuestoId());
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            Discrecional disc = new Discrecional(
                rs.getBoolean("Impulso"),                        
                rs.getString("Frecuencia"),                      
                rs.getString("Descripcion"),                     
                rs.getString("Nombre"),                          
                rs.getDouble("Monto"),                           
                Periocidad.valueOf(rs.getString("Periocidad")),  
                rs.getString("PresupuestoID")                    
            );
            disc.setId(rs.getString("ID"));
            discrecionales.add(disc);
        }

        return discrecionales;
    } catch (SQLException e) {
        System.out.println("Error al obtener gasto discrecional: " + e.getMessage() + " | SQLState: " + e.getSQLState());
        return null;
    }
}


}
