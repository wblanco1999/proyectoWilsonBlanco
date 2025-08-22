/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectofinalwb.dao;

/**
 *
 * @author wilsonblanco
 */
public interface DAO<T, S> {
    void insertar(T S);
    void modificar(T S);
    void obtener(T S);
    void eliminar(T S);
    void obtenerTodo(T S);
}
