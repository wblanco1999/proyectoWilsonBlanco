/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Apache_derby.business;

import java.sql.*;

/**
 *
 * @author wilsonblanco
 */
public class Conexion {
    private static Connection conexion;
    
    
    public static Connection getConexion(){
        if(conexion != null){
            return conexion;
        }
        try{
            String url = "jdbc:derby:Terminos-WilsonBlanco;create=true";
            conexion = DriverManager.getConnection(url);
            System.out.println("Conexión hecha");
            
            
        }catch(SQLException ex){
            System.out.println("Error al conectar");
        }
        return conexion;
    }
}
