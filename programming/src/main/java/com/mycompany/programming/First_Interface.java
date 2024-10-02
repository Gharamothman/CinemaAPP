
package com.mycompany.programming;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import static java.awt.PageAttributes.MediaType.C;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import static java.lang.System.in;
import java.util.*;
import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.AncestorListener;

/**
 *
 * @author TOPLAPTOP
 */
public class First_Interface {

    public First_Interface() {

        JButton button;
        ImageIcon image1;
        JLabel label;

        JFrame frame = new JFrame();

        frame.setSize(400, 400);
        frame.setLayout(null);
//        label = new JLabel();
//
        image1 = new ImageIcon("KK.JFIF");
//        label.setIcon(image1);
//    label.setBounds(85, 20, 300, 300);
//        frame.add(label);
///////////////////////////////////////
        label = new JLabel();
        label.setIcon(image1);
        label.setText("CINEMA SALAM");
        label.setFont(new Font("MV Boli", Font.ROMAN_BASELINE, 16));
        label.setForeground(Color.RED);
        label.setBounds(100, 30, 280, 300);
        label.setHorizontalTextPosition(label.CENTER);
        label.setVerticalTextPosition(label.BOTTOM);
        label.setIconTextGap(8);
        label.addMouseListener(new MouseListener() {
         
            @Override
            public void mouseEntered(MouseEvent e) {

              
                label.setForeground(new Color(133, 150, 180));
                 new logIn();
                frame.dispose();
            }

            @Override
            public void mouseExited(MouseEvent e) {

               

            }

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

        });

        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setVisible(true);
        frame.setResizable(false);
         frame.setLocation(500, 200);
    }

}
