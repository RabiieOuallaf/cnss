package com.macnss.view.Authentication;

import com.macnss.app.Models.Company;
import com.macnss.app.Models.user.Employee;
import com.macnss.app.Services.Authentication;

import com.macnss.view.Employee.index;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SigninEmployee extends JFrame implements ActionListener {
    Authentication auth;

    private JPasswordField matricule;
    private JButton resetButton, signInButton;
    private JLabel matriculeLabel;
    private ImageIcon userIcon, passwordIcon;
    private Image logo;

    private String enteredMatricule= null;

    public SigninEmployee() {
        auth = new Authentication();

        setTitle("Signin employee");
        setSize(560, 730);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        userIcon = new ImageIcon("user.png");
        passwordIcon = new ImageIcon("password.png");

        ImageIcon logoIcon = new ImageIcon("assets/images/app/cnss.png");
        Image logo = logoIcon.getImage();

        setIconImage(logo);

        matricule = new JPasswordField();
        matriculeLabel = new JLabel("Matricule : ");
        resetButton = new JButton("R");
        signInButton = new JButton("Sign in");


        JLabel logoLabel = new JLabel(new ImageIcon(logo));
        logoLabel.setBounds(130, 40,300 , 282);


        matriculeLabel.setBounds(40, 340, 470, 30);
        matriculeLabel.setIcon(userIcon);
        matricule.setBounds(40, 375, 460, 35);


        signInButton.setBounds(45, 620, 170, 30);
        signInButton.setForeground(new Color(29, 170, 172));
        signInButton.setFont(new Font("Arial", Font.PLAIN, 16));
        signInButton.setOpaque(true);
        signInButton.setContentAreaFilled(false);
        signInButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));



        resetButton.addActionListener(this);
        signInButton.addActionListener(this);

        add(logoLabel);
        add(matriculeLabel);
        add(matricule);
        add(signInButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == signInButton) {
            enteredMatricule = new String(matricule.getPassword());
            try {
                new index(new Employee(),enteredMatricule);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SigninEmployee().setVisible(true);
        });
    }
}
