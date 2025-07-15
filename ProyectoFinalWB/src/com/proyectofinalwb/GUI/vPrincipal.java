/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalwb.GUI;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author wilsonblanco
 */
public class vPrincipal extends JFrame{
    private CardLayout cardLayout;
    private JPanel vPrincipal;
    private vLogin pLogin;
    private vRegistrar pRegistrar;

    public vPrincipal() {
        setTitle("Sistema de Login");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        cardLayout = new CardLayout();
        vPrincipal = new JPanel(cardLayout);
        
        pLogin = new vLogin(this);
        pRegistrar = new vRegistrar(this);
        
        vPrincipal.add(pLogin, "Login");
        vPrincipal.add(pRegistrar, "Register");
        
        add(vPrincipal);
        mostrarPanelLogin();
    }
    
    public void mostrarPanelLogin() {
        cardLayout.show(vPrincipal, "Login");
    }
    
    public void mostrarPanelRegistrar() {
        cardLayout.show(vPrincipal, "Register");
    }
}
