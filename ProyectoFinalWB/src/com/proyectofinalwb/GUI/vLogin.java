/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalwb.GUI;

import com.proyectofinalwb.Data.UsuariosData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author wilsonblanco
 */
public class vLogin extends JPanel implements ActionListener {

    private JTextField usernameField;
    private JPasswordField passwd;
    private JButton loginButton;
    private JButton registerButton;
    private vPrincipal pPrincipal;

    public vLogin(vPrincipal pPrincipal) {
        this.pPrincipal = pPrincipal;
        setSize(800, 600);
        setLayout(null);
        initializeComponents();
    }

    private void initializeComponents() {
        JLabel userLabel = new JLabel("Usuario:");
        userLabel.setBounds(250, 225, 100, 25);
        add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(350, 225, 150, 25);
        add(usernameField);

        JLabel passLabel = new JLabel("Contraseña:");
        passLabel.setBounds(250, 265, 100, 25);
        add(passLabel);

        passwd = new JPasswordField();
        passwd.setBounds(350, 265, 150, 25);
        add(passwd);

        loginButton = new JButton("Iniciar sesión");
        loginButton.setBounds(275, 305, 120, 30);
        add(loginButton);

        registerButton = new JButton("Registrarse");
        registerButton.setBounds(405, 305, 120, 30);
        add(registerButton);

        registerButton.addActionListener(this);
        loginButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            this.pPrincipal.mostrarPanelRegistrar();
        } else if (e.getSource() == loginButton) {
            try {
                UsuariosData u = new UsuariosData();
                char[] passwordChars = passwd.getPassword();
                String password = new String(passwordChars);
                u.iniciarSesion(usernameField.getText(), password);
            } catch (Exception ex) {

            } finally{
                passwd.setText("");
                usernameField.setText("");
            }
        }

    }//actionPreformed
}
