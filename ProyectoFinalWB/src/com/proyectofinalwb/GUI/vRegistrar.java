/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalwb.GUI;

import com.proyectofinalwb.Data.UsuariosData;
import com.proyectofinalwb.main.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author wilsonblanco
 */
public class vRegistrar extends JPanel implements ActionListener {

    private JTextField usernameField;
    private JTextField correo;
    private JPasswordField passwd;
    private JButton botonRegistrar;
    private JButton botonVolver;
    private vPrincipal vPrincipal;

    public vRegistrar(vPrincipal vPrincipal) {
        this.vPrincipal = vPrincipal;
        setSize(800, 600);
        setLayout(null);
        initializeComponents();
    }

    private void initializeComponents() {
        JLabel labelUsuario = new JLabel("Nombre de usuario:");
        labelUsuario.setBounds(200, 180, 150, 25);
        add(labelUsuario);

        usernameField = new JTextField();
        usernameField.setBounds(350, 180, 250, 25);
        add(usernameField);

        JLabel labelCorreo = new JLabel("Correo electrónico");
        labelCorreo.setBounds(200, 220, 150, 25);
        add(labelCorreo);

        correo = new JTextField();
        correo.setBounds(350, 220, 250, 25);
        add(correo);

        JLabel labelpasswd = new JLabel("Contraseña");
        labelpasswd.setBounds(200, 260, 150, 25);
        add(labelpasswd);

        passwd = new JPasswordField();
        passwd.setBounds(350, 260, 250, 25);
        add(passwd);

        botonRegistrar = new JButton("Registrar");
        botonRegistrar.setBounds(300, 310, 120, 30);
        add(botonRegistrar);

        botonVolver = new JButton("Volver");
        botonVolver.setBounds(430, 310, 120, 30);
        add(botonVolver);

        botonVolver.addActionListener(this);
        botonRegistrar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonVolver) {
            this.vPrincipal.mostrarPanelLogin();
        } else if (e.getSource() == botonRegistrar) {
            try {
                char[] passwordChars = passwd.getPassword();
                String password = new String(passwordChars);
                UsuariosData ud = new UsuariosData();
                ud.registrarUsuario(new Usuario(usernameField.getText(), correo.getText(), password));
                
           } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Acción inválida.");
            } finally{
                passwd.setText("");
                correo.setText("");
                usernameField.setText("");
            }
        }
    }//actionPreformed
}
