/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalwb.main;

import com.proyectofinalwb.sql.IdSQL;
import java.util.Random;

/**
 *
 * @author wilsonblanco
 */
public class ID {

    public ID() {
    }
    
    public static String generarID(){
        Random r = new Random();
        int random = r.nextInt(900000) + 100000;
        return String.valueOf(random);
    }
    
    public static String agregarID(){
        String id = generarID();
        IdSQL sql = new IdSQL();
        id = sql.insertar(id);
        if(id != null){
            return id;
            
        }
        else{
            agregarID();
        }
        return id;
    }
    
    
}
