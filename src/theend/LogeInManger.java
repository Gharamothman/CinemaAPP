package theend;

import javax.swing.*;
import java.awt.*;
import static java.awt.SystemColor.text;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class LogeInManger {

    ArrayList<User> userList11 = new ArrayList<>();
    JPasswordField password;
    JFrame frame;
    JLabel label1, label2, label3;
    JTextField t1;
    static String name, pass;
    JButton button;
    JLabel message;
    static String gender, age;

    public LogeInManger(ArrayList userlist) {   /// we can cancel reserve a parameter by read this list from file 
        ArrayList<User> userList1 = userlist;
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(420, 420);
        frame.setTitle("LogIN");
        frame.setLocation(500, 200);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        ImageIcon key = new ImageIcon("pass.PNG");
        frame.setIconImage(key.getImage());

        /// about label login 
        label1 = new JLabel("LogIn");
        label1.setVisible(true);
        label1.setBounds(160, 10, 100, 100);
        frame.add(label1);
        label1.setForeground(Color.white);
        Font font1 = new Font("Monotype Corsive", Font.ITALIC, 28);

        label1.setFont(font1);

        /// about label user name       
        label2 = new JLabel("User_name : ");
        label2.setVisible(true);
        label2.setBounds(10, 80, 100, 80);
        frame.add(label2);
        label2.setForeground(Color.white);
        Font font2 = new Font("Monotype Corsive", Font.ITALIC, 14);
        label2.setFont(font2);
        t1 = new JTextField(20);

        t1.setBorder(BorderFactory.createMatteBorder(3, 1, 5, 1, Color.BLACK));
        t1.setBounds(50, 140, 150, 20);
        Font fonttext = new Font("Arial", Font.PLAIN, 10);
        t1.setForeground(Color.white);
        t1.setFont(fonttext);
        t1.setBackground(new Color(0x3D3f9C));
        t1.setBorder(BorderFactory.createLineBorder(new Color(0x3D3f9C), 1));
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
        Font font3 = new Font("Monotype Corsive", Font.ITALIC, 14);
        label3.setFont(font3);
        password = new JPasswordField();
        password.setBounds(50, 240, 150, 20);
        Font fontpass = new Font("Arial", Font.PLAIN, 10);
        password.setFont(fontpass);

        password.setForeground(Color.white);
        password.setBackground(new Color(0x3D3f9C));
        password.setBorder(BorderFactory.createLineBorder(new Color(0x3D3f9C), 1));
        frame.add(password);

        JCheckBox checkBox = new JCheckBox();
        checkBox.setBounds(205, 230, 200, 40);
        checkBox.setFont(font2);
        checkBox.setFocusable(false);
        ImageIcon image1 = new ImageIcon("see.JPG");
        checkBox.setIcon(image1);
        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBox.isSelected()) {
                    password.setEchoChar((char) 0);
                } else {
                    password.setEchoChar('*');
                }
            }
        });
        checkBox.setBackground(new Color(0x5D4E9C));
        frame.add(checkBox);

    
        // adding the button
        button = new JButton();
        button.setText("Continue");
        button.setFocusable(false);
        button.setFont(font2);
        button.setBackground(new Color(0x3D3f9C));
        button.setBounds(10, 300, 385, 25);
        button.setForeground(Color.white);
        button.setBorder(BorderFactory.createLineBorder(new Color(0x3D3f9C), 5));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = t1.getText();
                pass = new String(password.getPassword());

                boolean userFound = false;
                for (User user : userList1) {
                    if (user.getUsername().equals(name) && user.getPassword().equals(pass)) {
                        age = user.getAge();
                        gender = user.getGender();
                        new Option();

                        userFound = true;
                        break;
                    }
                }

                if (!userFound) {
                    t1.setText("");
                    password.setText("");
                }
            }
        });
        frame.add(button);

        frame.getContentPane().setBackground(new Color(0x5D4E9C));

    }

}
