package com.mycompany.programming;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Try {
 String nameMovie;
    public Try() {
        JFrame frame = new JFrame("Main");
        frame.setSize(500, 500);
        frame.setLocation(500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel_L = new JPanel();
        JPanel panel_R = new JPanel();
        panel_L.setLayout(new GridLayout(4, 1));
        /////button
        ImageIcon imagehome = new ImageIcon("home.PNG");
        JButton home = new JButton(imagehome);
        home.setBackground(new Color(0x354f52));
        home.setFocusable(false);

        ImageIcon imagebooking = new ImageIcon("ticket.PNG");
        JButton booking = new JButton(imagebooking);
        booking.setFocusable(false);
        booking.setBackground(new Color(0x354f52));

        ImageIcon imagecancel = new ImageIcon("cancel0.PNG");
        JButton cancelBooking = new JButton(imagecancel);
        cancelBooking.setFocusable(false);
        cancelBooking.setBackground(new Color(0x354f52));

        ImageIcon imageshow = new ImageIcon("show.PNG");
        JButton showMovie = new JButton(imageshow);
        showMovie.setFocusable(false);
        showMovie.setBackground(new Color(0x354f52));

        panel_L.add(home);
        panel_L.add(booking);
        panel_L.add(cancelBooking);
        panel_L.add(showMovie);
        panel_L.setBackground(new Color(0x2F3E46));

        JPanel homePanel = new JPanel();
        homePanel.setLayout(null);
//        JButton sh = new JButton("hihjbhjnjknj");
//          JLabel comment = new JLabel("leave a comment : ");
//          comment.setBounds(20, 50, 90,100);
//        JTextField textcom = new JTextField("0");
//        textcom.setBounds(30, 20, 60, 60);
//       homePanel.add(comment);
//        homePanel.add(textcom);
//sh.setBounds(10, 80, 90,100);
//sh.add(homePanel);
        JPanel bookingPanel = new JPanel(new GridLayout(6, 1));
        JPanel cancelBookingPanel = new JPanel();
        JPanel showMoviePanel = new JPanel();

        CardLayout card = new CardLayout();

        panel_R.setLayout(card);
        panel_R.add(homePanel, "Home");

        panel_R.add(bookingPanel, "Booking");
        panel_R.add(cancelBookingPanel, "Cancel Booking");
        panel_R.add(showMoviePanel, "Show Movie");

        frame.add(panel_L, BorderLayout.EAST);
        frame.add(panel_R, BorderLayout.CENTER);

        ////محتوى بانيل
// 
        JLabel user=new JLabel("your name: ");
         user . setBounds(10, 20, 80, 80);
         homePanel .add(user);
        
        
        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel();

        Object[][] data = {
            {"     Avengers    ", "Action", "9/10", "10:00 a.m", "4:00 p.m"},
            {"     Conjuring   ", "Horror", "7/10", "12:00 a.m", "6:00 p.m"},
            {"     Inception   ", "Sci-fi", "8.5/10", "2:00 p.m", "8:00 p.m"},
            {"     Me before you", "Romance", "5/10", "10:00 p.m"}};

        Object[] columnNames = {"Title", "Genre", "Rating", "Showtimes"};

        JTable table1 = new JTable(data, columnNames);
        table1.setBackground(new Color(0xBBD0FF));
        table1.setForeground(Color.white);
        JScrollPane scrollPane = new JScrollPane(table1);
        showMoviePanel.setBackground(new Color(0xBBD0FF));

        showMoviePanel.add(new JScrollPane(table1));

/////محتوى ال booking
        JLabel nameLabel = new JLabel();
        nameLabel.setText("Name of the movie:");
        Font font = new Font("Arial", Font.PLAIN, 14);
        nameLabel.setFont(font);
        nameLabel.setForeground(Color.WHITE);
        bookingPanel.add(nameLabel);

        JTextField nameTextField = new JTextField();
        nameTextField.setForeground(Color.BLACK);
        nameTextField.setBackground(new Color(0xBBD0FF));
        bookingPanel.add(nameTextField);
        nameTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameMovie =nameTextField.getText();
            }
        });

        JLabel timeLabel = new JLabel();
        timeLabel.setText("Time of the movie:");
        timeLabel.setFont(font);
        timeLabel.setForeground(Color.WHITE);
        bookingPanel.add(timeLabel);

        JComboBox<String> timeComboBox = new JComboBox<>();
        timeComboBox.addItem("");
        timeComboBox.addItem("10:00pm");
        timeComboBox.addItem("2:00pm");
        timeComboBox.addItem("6:00pm");
        timeComboBox.setBackground(new Color(0xBBD0FF));
        timeComboBox.setForeground(Color.BLACK);
        bookingPanel.add(timeComboBox);
//
//        JLabel seatLabel = new JLabel();
//        seatLabel.setText("Number of seats:");
//        seatLabel.setFont(font);
//        seatLabel.setForeground(Color.WHITE);
//        bookingPanel.add(seatLabel);
//        String totalseat = "100";
//        JButton bookButton = new JButton(totalseat);
//        bookButton.setFocusable(false);
//        bookButton.setBackground(new Color(0x354f52));
//        bookButton.setForeground(Color.BLACK);
//        bookButton.setBackground(new Color(0xBBD0FF));
//        bookingPanel.add(bookButton);
//
//        JLabel labelticket = new JLabel("Ticketing : ");
//        JTextField textticket = new JTextField("0");
//        bookingPanel.add(labelticket);
//        bookingPanel.add(textticket);
//        textticket.setBackground(new Color(0xBBD0FF));
//

        JLabel pay = new JLabel();
        pay.setText("pay: ");
        pay.setForeground(Color.WHITE);
        pay.setBackground(new Color(0xBBD0FF));
        pay.setBounds(5, 5, 10, 10);
        bookingPanel.add(pay);
        JButton button2 = new JButton();

        button2.setForeground(Color.black);
        button2.setBackground(new Color(0xBBD0FF));
        button2.setText("0");
        bookingPanel.add(button2);
        bookingPanel.setBackground(new Color(0x354f52));

        JButton bookButton2 = new JButton("OK");
        bookButton2.setFocusable(false);
        bookButton2.setBackground(new Color(0x354f52));
        bookButton2.setForeground(Color.BLACK);
        bookButton2.setBackground(new Color(0xBBD0FF));

        JButton bookButton3= new JButton("OK");
        bookButton3.setFocusable(false);
        bookButton3.setBackground(new Color(0x354f52));
        bookButton3.setForeground(Color.BLACK);
        bookButton3.setBackground(new Color(0xBBD0FF));
        bookButton3.setSize(50,50);
        bookingPanel.add(bookButton3);
        bookButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               nameMovie =nameTextField.getText();
                String timeMovie = (String) timeComboBox.getSelectedItem();
               
                if(timeMovie!=null)
                     System.out.println(timeMovie);
                else 
                    System.out.println("null");
            }
        });
         
                 
             
        
        
        
        
        
        
        
        
        
        home.addMouseListener(new MouseListener() {

            @Override
            public void mouseEntered(MouseEvent e) {
                card.show(panel_R, "Home");

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
        booking.addMouseListener(new MouseListener() {

            @Override
            public void mouseEntered(MouseEvent e) {
                card.show(panel_R, "Booking");

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
        cancelBooking.addMouseListener(new MouseListener() {

            @Override
            public void mouseEntered(MouseEvent e) {
                card.show(panel_R, "Cancel Booking");

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
        showMovie.addMouseListener(new MouseListener() {

            @Override
            public void mouseEntered(MouseEvent e) {
                card.show(panel_R, "Show Movie");

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

        frame.setVisible(true);
    }

}
