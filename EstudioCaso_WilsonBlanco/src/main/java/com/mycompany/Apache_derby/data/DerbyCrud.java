/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Apache_derby.data;

import com.mycompany.Apache_derby.Termino;
import com.mycompany.Apache_derby.business.Conexion;
import java.sql.*;
import javax.swing.JTextArea;

/**
 *
 * @author wilsonblanco
 */
public class DerbyCrud {
    Connection con = Conexion.getConexion();
    private JTextArea bitacora;

    public DerbyCrud(JTextArea bitacora) {
        this.bitacora = bitacora;
    }
    
    
    
    public void crearTabla(){
        
        try
        {
            Statement st = con.createStatement();
            
            String sql = "Create TABLE Terminos ("+
                    "PALABRA VARCHAR(100) NOT NULL PRIMARY KEY,"+
                    "CONCEPTO VARCHAR(255) NOT NULL)";
            st.executeUpdate(sql);
            this.bitacora.append("\nTabla creada exitosamente.");
            
            
        }catch(SQLException e){
            if(e.getSQLState().equals("X0732")){
                System.out.println("La tabla existe");
                this.bitacora.append("\nTabla ya existe.");
            }
            else{
                System.out.println("Error" + e.getMessage());
                this.bitacora.append("\nError en SQL:" + e.getMessage());
            }
        }
    }
    
    public boolean insertarTermino(Termino termino){
        String sql = "INSERT INTO Terminos(PALABRA,CONCEPTO)"+
                "VALUES(?,?)";
        try
        {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, termino.getPalabra());
            st.setString(2, termino.getPalabra());
            st.executeUpdate();
            this.bitacora.append("\nPalabra insertada:" + termino.getPalabra());
            this.bitacora.append("\nConcepto insertado:" + termino.getConcepto());
            this.bitacora.append("\nInsertado en tabla exitosamente.");
            return true;
        }catch(SQLException e){
            System.out.println("Error " + e.getMessage());
            
            this.bitacora.append("\nError al insertar en tabla."+e.getMessage());
            return false;
        }
        
    }
    
}
