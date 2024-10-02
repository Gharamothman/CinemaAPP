package theend;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Account {

    public Account() {
        ImageIcon key = new ImageIcon("account.PNG");

        JFrame frame = new JFrame();
        frame.setIconImage(key.getImage());
        frame.setVisible(true);
        frame.setSize(420, 420);
        frame.setTitle("Account");
        frame.setLocation(500, 200);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        ImageIcon image1 = new ImageIcon("cinema.PNG");
        JLabel l = new JLabel(image1);
        l.setBounds(0, 0, 600, 600);
        frame.add(l);
        frame.getContentPane().setBackground(new Color(0x5D4E9C));
        JTextField textField = new JTextField("       your information:  ");
        Border emptyBorder = BorderFactory.createEmptyBorder();
        textField.setBorder(emptyBorder);
        frame.add(textField);
        Font font3 = new Font("Monotype Corsive", Font.ITALIC, 14);
        textField.setFont(font3);
        textField.setForeground(Color.BLACK);
        textField.setBounds(10, 40, 220, 25);
        textField.setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, new Color(0x5D4E9C)));
        textField.setFocusable(false);
        textField.setBackground(new Color(0x3D3f9C));

        JButton button = new JButton();
        button.setText(" >> ");
        button.setFocusable(false);
        button.setFont(font3);
        button.setBackground(new Color(0x3D3f9C));
        button.setBounds(350, 30, 40, 25);
        button.setForeground(Color.white);
        button.setBorder(BorderFactory.createLineBorder(new Color(0x3D3f9C), 5));
        frame.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Option();
            }

        });

        JTextField textFieldname = new JTextField("       name :  " + LogeInManger.name);
        textFieldname.setBorder(emptyBorder);
        frame.add(textFieldname);
        textFieldname.setFont(font3);
        textFieldname.setForeground(Color.BLACK);
        textFieldname.setBounds(10, 70, 220, 25);
        textFieldname.setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, new Color(0x5D4E9C)));
        textFieldname.setFocusable(false);
        textFieldname.setBackground(new Color(0x3D3f9C));

        JTextField textFieldage = new JTextField("       age :  " + LogeInManger.age);
        textFieldage.setBorder(emptyBorder);
        frame.add(textFieldage);
        textFieldage.setFont(font3);
        textFieldage.setForeground(Color.BLACK);
        textFieldage.setBounds(10, 100, 220, 25);
        textFieldage.setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, new Color(0x5D4E9C)));
        textFieldage.setFocusable(false);
        textFieldage.setBackground(new Color(0x3D3f9C));

        JTextField textFieldgender = new JTextField("       gender:  " + LogeInManger.gender);
        textFieldgender.setBorder(emptyBorder);
        frame.add(textFieldgender);
        textFieldgender.setFont(font3);
        textFieldgender.setForeground(Color.BLACK);
        textFieldgender.setBounds(10, 130, 220, 25);
        textFieldgender.setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, new Color(0x5D4E9C)));
        textFieldgender.setFocusable(false);
        textFieldgender.setBackground(new Color(0x3D3f9C));

        JTextField textFieldw = new JTextField(" W");
        textFieldw.setBorder(emptyBorder);
        frame.add(textFieldw);
        textFieldw.setFont(font3);
        textFieldw.setForeground(Color.BLACK);
        textFieldw.setBounds(10, 180, 30, 25);
        textFieldw.setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, new Color(0x5D4E9C)));
        textFieldw.setFocusable(false);
        textFieldw.setBackground(new Color(0x3D3f9C));

        JTextField textFieldE = new JTextField("  E");
        textFieldE.setBorder(emptyBorder);
        frame.add(textFieldE);
        textFieldE.setFont(font3);
        textFieldE.setForeground(Color.BLACK);
        textFieldE.setBounds(50, 180, 30, 25);
        textFieldE.setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, new Color(0x5D4E9C)));
        textFieldE.setFocusable(false);
        textFieldE.setBackground(new Color(0x3D3f9C));

        JTextField textFieldL = new JTextField("  L");
        textFieldL.setBorder(emptyBorder);
        frame.add(textFieldL);
        textFieldL.setFont(font3);
        textFieldL.setForeground(Color.BLACK);
        textFieldL.setBounds(90, 180, 30, 25);
        textFieldL.setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, new Color(0x5D4E9C)));
        textFieldL.setFocusable(false);
        textFieldL.setBackground(new Color(0x3D3f9C));

        JTextField textFieldC = new JTextField("  C");
        textFieldC.setBorder(emptyBorder);
        frame.add(textFieldC);
        textFieldC.setFont(font3);
        textFieldC.setForeground(Color.BLACK);
        textFieldC.setBounds(130, 180, 30, 25);
        textFieldC.setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, new Color(0x5D4E9C)));
        textFieldC.setFocusable(false);
        textFieldC.setBackground(new Color(0x3D3f9C));

        JTextField textFieldO = new JTextField("  O");
        textFieldO.setBorder(emptyBorder);
        frame.add(textFieldO);
        textFieldO.setFont(font3);
        textFieldO.setForeground(Color.BLACK);
        textFieldO.setBounds(170, 180, 30, 25);
        textFieldO.setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, new Color(0x5D4E9C)));
        textFieldO.setFocusable(false);
        textFieldO.setBackground(new Color(0x3D3f9C));

        JTextField textFieldM = new JTextField("  M");
        textFieldM.setBorder(emptyBorder);
        frame.add(textFieldM);
        textFieldM.setFont(font3);
        textFieldM.setForeground(Color.BLACK);
        textFieldM.setBounds(210, 180, 30, 25);
        textFieldM.setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, new Color(0x5D4E9C)));
        textFieldM.setFocusable(false);
        textFieldM.setBackground(new Color(0x3D3f9C));

        JTextField textFieldm = new JTextField("  E");
        textFieldm.setBorder(emptyBorder);
        frame.add(textFieldm);
        textFieldm.setFont(font3);
        textFieldm.setForeground(Color.BLACK);
        textFieldm.setBounds(250, 180, 30, 25);
        textFieldm.setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, new Color(0x5D4E9C)));
        textFieldm.setFocusable(false);
        textFieldm.setBackground(new Color(0x3D3f9C));
    }
}
