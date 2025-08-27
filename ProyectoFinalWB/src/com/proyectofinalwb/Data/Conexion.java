/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalwb.Data;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author wilsonblanco
 */
public class Conexion {
    private static final String SGBD = "com.mysql.cj.jdbc.Driver";
    private static final String BBDD = "jdbc:mysql://localhost:3306/Proyecto";
    private static final String usuario = "root";
    private static final String passwd = "Tsukuyomi1";
    
    public static Connection conexion(){
        
    Connection conex = null;
    try {
        Class.forName(SGBD);
        conex = DriverManager.getConnection(BBDD, usuario, passwd);
    } catch(Exception e){
        System.out.println("Problemas al conectar");
        System.out.println(e.getMessage());
    }
    return conex;
}

    
    public static void cerrarConexion(Connection conex){
        try{
            conex.close();
            
        }
        catch(Exception e){
            System.out.println("ERROR ");
            
        }
        
    }
}
