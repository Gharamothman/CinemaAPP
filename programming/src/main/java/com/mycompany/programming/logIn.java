/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.programming;

/**
 *
 * @author TOPLAPTOP
 */


import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.*;

public class logIn extends JFrame {
    
    JPasswordField password;
    JFrame frame;
    JLabel label1,label2,label3;
    JTextField t1;
  static String name, pass;
    JButton button;
    JLabel message;

    public logIn() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(420, 420);
        frame.setTitle("LogIN");
        frame.setLocation(500, 200);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        ImageIcon key = new ImageIcon("key.PNG");
        frame.setIconImage(key.getImage());

        /// about label login 
         label1 = new JLabel("LogIn");
        label1.setVisible(true);
        label1.setBounds(160, 10, 100, 100);
        frame.add(label1);
        label1.setForeground(Color.white);
        Font font1 = new Font("Monotype Corsive", Font.ITALIC, 24);
        label1.setFont(font1);

        /// about label user name       
         label2 = new JLabel("User_name : ");
        label2.setVisible(true);
        label2.setBounds(10, 80, 100, 80);
        frame.add(label2);
        label2.setForeground(Color.white);
        Font font2 = new Font("Monotype Corsive", Font.ITALIC, 14);
        label2.setFont(font2);
        t1 = new JTextField();
        t1.setBounds(50, 140, 150, 20);
        Font fonttext = new Font("Arial",Font.PLAIN,10);
        t1.setForeground(Color.white);
        t1.setFont(fonttext);
        t1.setBackground(new Color(0x354f52));
        frame.add(t1);
        
        t1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = t1.getText();
            }
        });
        // about label password
         label3 = new JLabel("Password : ");
        label3.setBounds(10, 180, 100, 80);
        frame.add(label3);
        label3.setForeground(Color.white);
        Font font3 = new Font("Edwardian Script", Font.PLAIN, 14);
        label3.setFont(font3);
         password = new JPasswordField();
        password.setBounds(50, 240, 150, 20);
        Font fontpass = new Font("Arial",Font.PLAIN,10);
        password.setFont(fontpass);
        password.setForeground(Color.white);
        password.setBackground(new Color(0x354f52));
        frame.add(password);
       /* password.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pass = password.getText();
}
        });*/
       message = new JLabel();
       message.setBounds(100, 280, 250, 20);
       frame.add(message);
        // adding the button
        button = new JButton();
        button.setText("Continue");
        button.setFocusable(false);
        button.setBackground(new Color(0x354f52));
        button.setBounds(10, 300, 385, 25);
        button.setForeground(Color.white);
        button.setBorder(BorderFactory.createLineBorder(Color.white,1));
        frame.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  name = t1.getText();
                  pass = new String(password.getPassword());
                if (name == null || pass == null) {
                    button.setBackground(Color.RED);
                } else {
                    try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("user.dat"))) {
            while (true) {
                try {
                    User user = (User) objectInputStream.readObject();
              if(name.equals(user.getUsername()) &&pass.equals(user.getPassword()))
                          new Main();
                } catch (EOFException c) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException ev) {
            ev.printStackTrace();
        }
           
                }}});
                frame.getContentPane().setBackground(new Color(0x2F3E46));
                

        
   }
    private void loadUsersFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("users.dat"))) {
            users = (List<User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // يمكنك التعامل مع أي استثناء هنا حسب احتياجاتك
            e.printStackTrace();
        }  
}

