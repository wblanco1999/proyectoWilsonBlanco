/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectofinalwb.dao;

import java.util.List;

/**
 *
 * @author wilsonblanco
 */
public interface DAO<T> {
    boolean insertar(T t);
    boolean modificar(T t);
    List<T> obtener(T t);
    boolean eliminar(T t);
}
