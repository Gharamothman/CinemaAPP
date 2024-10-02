package com.mycompany.programming;

import static com.mycompany.programming.User.saveUsersToFile;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import static java.awt.PageAttributes.MediaType.C;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import static java.lang.System.in;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class Programming {

//        Scanner in = new Scanner(System.in);
//        ArrayList<String> I = new ArrayList();
//        I.add("int");
//        I.add("import");
//        ArrayList<String> S = new ArrayList();
//        I.add("String");
//        I.add("System");
//        ArrayList<String> C = new ArrayList();
//        I.add("comparto");
//        I.add("clacc");
//        String word = in.next();
//        for (int i = 97; i <= 102; i++) {
//
//            if ((char) i == word.charAt(0) || (char) i - 32 == word.charAt(0)) {
//                
//                System.out.println((char) i);
//                System.out.println("hhhh");
//               
////                j.add(word);
//            }
//             System.out.println((char) i);
//                System.out.println("hhhh");
//                
//        }
//User user1=new User("gharam","12345");
//User user2=new User("salam","12345");
//  new First_Interface();
    public static void main(String[] args) {
        User user1 = new User("gharam", "12345", 25, "Female");
        User user2 = new User("john_doe", "password123", 30, "Male");
        user1.setUsername("nay");
        User.saveUsersToFile("users.dat", user1, user2);
        User.readUsersFromFile("users.dat");
        ////object from movie :
        Movie m1 = new Movie("avatar", "10:00pm");
        m1.saveInfile();
        Movie m2 = new Movie("me befor you ", "10:00pm");
        m2.saveInfile();

        new Main();

//      JFrame frame = new JFrame("CardLayout demo");
//frame.setSize(520, 520);
//frame.setLocation(500, 200);
//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
////         تعريف الأزرار  هنا بالازرار 
////JButton home = new JButton("Home");
////home.setFocusable(false);
////home.setBackground(Color.red);
////JButton booking = new JButton("Booking");
////booking.setFocusable(false);
////booking.setBackground(Color.red);
////JButton cancelBooking = new JButton("Cancel Booking");
////cancelBooking.setFocusable(false);
////cancelBooking.setBackground(Color.red);
////JButton showMovie = new JButton("Show Movie");
////showMovie.setFocusable(false);
////showMovie.setBackground(Color.red);
//
//
//
//
//
////////// هنا باليبل 
//JLabel home= new JLabel("Home");
//  
//
//home.setBounds(10,5, 40, 2);
//home.setForeground(Color.white);
//JLabel booking= new JLabel("Booking");
//booking.setBounds(20,5, 20, 2);
//booking.setForeground(Color.white);
//JLabel cancelBooking= new JLabel("Cancel booking");
//cancelBooking.setBounds(20,5, 20, 2);
// cancelBooking.setForeground(Color.white);
//JLabel showMovie= new JLabel("Show movie");
//showMovie.setBounds(20,5, 20, 2);
//showMovie.setForeground(Color.white);
//// تعريف البانيلات
//JPanel panel_L = new JPanel();
//JPanel panel_R = new JPanel();
//panel_L.setLayout(new GridLayout(4, 1));
//
//// إضافة الأزرار إلى البانيل الأيسر
//panel_L.add(home);
//panel_L.add(booking);
//panel_L.add(cancelBooking);
//panel_L.add(showMovie);
//
//// تعريف وإعداد الـ CardLayout
//CardLayout card = new CardLayout();
//panel_R.setLayout(card);
//
//// تعريف البانيلات
//JPanel homePanel = new JPanel();
//homePanel.setBounds(50,30,89,90);
//JPanel  bookingPanel = new JPanel(new GridLayout(12, 1));
//JPanel cancelBookingPanel = new JPanel();
//JPanel showMoviePanel = new JPanel();
//
//
//
//
//
//
//panel_L.setBackground(new Color(0x2F3E46));
//
//// إضافة البانيلات إلى البانيل الأيمن
//
//panel_R.add(homePanel, "Home");
//
//panel_R.add(bookingPanel, "Booking");
//panel_R.add(cancelBookingPanel, "Cancel Booking");
//panel_R.add(showMoviePanel, "Show Movie");
//// إنشاء جدول ونموذج للبيانات
//JTable table = new JTable();
//DefaultTableModel model = new DefaultTableModel();
//
//
//
//
//
//
//
//        //////////////////////////////////////
//
//      
//        Object[][] data = {
//            {"Avengers", "Action", "9/10", "10:00 a.m", "4:00 p.m"},
//            {"Conjuring", "Horror", "7/10", "12:00 a.m", "6:00 p.m"},
//            {"Inception", "Sci-fi", "8.5/10", "2:00 p.m", "8:00 p.m"},
//            {"Me before you", "Romance", "5/10", "10:00 p.m"}};
//
//        String[] columnNames = {"Title", "Genre", "Rating", "Showtimes"};
//        JTable tablee = new JTable(data, columnNames);
//        JScrollPane scrollPane = new JScrollPane(table);
//      
//     
//
//
//
//
//
//showMoviePanel.add(new JScrollPane(tablee));
//
//
//// إضافة البانيلات إلى الفريم
//frame.add(panel_L, BorderLayout.WEST);
//frame.add(panel_R, BorderLayout.CENTER);
//
//
//
//
///////////////
//    
// JLabel nameLabel = new JLabel();
//        nameLabel.setText("Name of the movie:");
//        Font font = new Font("Arial", Font.PLAIN, 14);
//        nameLabel.setFont(font);
//        nameLabel.setForeground(Color.WHITE);
//        bookingPanel.add(nameLabel);
//
//        JTextField nameTextField = new JTextField();
//        nameTextField.setForeground(Color.BLACK);
//        nameTextField.setBackground(new Color(0xBBD0FF));
//        bookingPanel.add(nameTextField);
//
//        JLabel timeLabel = new JLabel();
//        timeLabel.setText("Time of the movie:");
//        timeLabel.setFont(font);
//        timeLabel.setForeground(Color.WHITE);
//        bookingPanel.add(timeLabel);
//
//        JComboBox<String> timeComboBox = new JComboBox<>();
//        timeComboBox.addItem("");
//        timeComboBox.addItem("10:00pm");
//        timeComboBox.addItem("2:00pm");
//        timeComboBox.addItem("6:00pm");
//        timeComboBox.setBackground(new Color(0xBBD0FF));
//        timeComboBox.setForeground(Color.BLACK);
//        bookingPanel.add(timeComboBox);
//
//        JLabel seatLabel = new JLabel();
//        seatLabel.setText("Number of seats:");
//        seatLabel.setFont(font);
//        seatLabel.setForeground(Color.WHITE);
//        bookingPanel.add(seatLabel);
//        String totalseat = "100";
//        JTextField bookButton = new JTextField(totalseat);
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
//        JLabel pay = new JLabel();
//        pay.setText("pay: ");
//        pay.setForeground(Color.WHITE);
//        pay.setBackground(new Color(0xBBD0FF));
//        pay.setBounds(5, 5, 10, 10);
//        bookingPanel.add(pay);
//        JTextField text2 = new JTextField();
//
//        text2.setForeground(Color.black);
//        text2.setBackground(new Color(0xBBD0FF));
//        text2.setText("");
//        bookingPanel.add(text2);
//        bookingPanel.setBackground(new Color(0x354f52));
//        
//
//        JButton bookButton2 = new JButton("OK");
//        bookButton2.setFocusable(false);
//        bookButton2.setBackground(new Color(0x354f52));
//        bookButton2.setForeground(Color.BLACK);
//        bookButton2.setBackground(new Color(0xBBD0FF));
//
//        
//        
//        
//        
//        
//        
//        
//        
//        
//         JLabel comment = new JLabel("leave a comment : ");
//        JTextField textcom = new JTextField("0");
//       homePanel.add(comment);
//        homePanel.add(textcom);
//// تعريف وإضافة استماع الأزرار
//home.addMouseListener(new MouseListener() {
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                card.show(panel_R, "Home");
//              
//
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//
//              
//
//            }
//
//            @Override
//            public void mouseClicked(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//
//            }
//
//        });
//booking.addMouseListener(new MouseListener() {
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                card.show(panel_R, "Booking");
//              
//
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//
//              
//
//            }
//
//            @Override
//            public void mouseClicked(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//
//            }
//
//        });
//cancelBooking.addMouseListener(new MouseListener() {
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                card.show(panel_R, "Cancel Booking");
//              
//
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//
//              
//
//            }
//
//            @Override
//            public void mouseClicked(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//
//            }
//
//        });
//showMovie.addMouseListener(new MouseListener() {
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                card.show(panel_R, "Show Movie");
//              
//
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//
//              
//
//            }
//
//            @Override
//            public void mouseClicked(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//            }
//
//        });
//
//
//
//
//
//
//
//frame.setVisible(true);
    }
}
// 
//        // panel_R قمنا بإضافتها في الـ Panel سيتم عرض أول first هنا قلنا أنه عند النقر على الزر
//        first.addActionListener(new ActionListener() {
