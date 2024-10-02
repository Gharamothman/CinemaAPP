/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.programming;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author TOPLAPTOP
 */
public class MoviePanel extends JPanel {

    JLabel name;
    JLabel poster;

    public MoviePanel(String nam, String post) {
        setLayout(new BorderLayout());
        name = new JLabel(nam, SwingConstants.CENTER);
        poster = new JLabel(new ImageIcon(post), SwingConstants.CENTER);

    }

}
