package com.mycompany.programming;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Main extends JFrame {

    String nameMovie;
    static int Count = 0;
    static int price = 10;
    JLabel paylabel;
    JPanel homePanel;
    BufferedReader reader;
    BufferedWriter writer;
    int totalprice;
    static JComboBox namecombobox, combo1;

    public Main() {

        JFrame frame = new JFrame("Main");
        frame.setResizable(false);
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
        JPanel bookingPanel = new JPanel(new GridLayout(10, 1));
        JPanel cancelBookingPanel = new JPanel();
        JPanel showMoviePanel = new JPanel();

        CardLayout card = new CardLayout();

        panel_R.setLayout(card);
        panel_R.add(homePanel, "Home");

        panel_R.add(bookingPanel, "Booking");
        panel_R.add(cancelBookingPanel, "Cancel Booking");
        panel_R.add(showMoviePanel, "Show Movie");

        frame.add(panel_L, BorderLayout.WEST);
        frame.add(panel_R, BorderLayout.CENTER);

/////// بانيل الفيلم الاول 
        Container container = showMoviePanel;
        container.setLayout(card);
        JPanel panel1 = new JPanel(new BorderLayout());
        ImageIcon icon1 = new ImageIcon("avatar.JPG");
        Image image1 = icon1.getImage();
        Image newicon1 = image1.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
//        icon1 = new ImageIcon(newicon1);
//        ImageIcon like = new ImageIcon("like.JPG");
//        Image image9 = like.getImage();
//        Image likee = image9.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
//        like = new ImageIcon(likee);
        JLabel label1 = new JLabel(icon1);
        label1.setText("Type : Sci-fi");
        label1.setHorizontalTextPosition(label1.CENTER);
        label1.setVerticalTextPosition(label1.BOTTOM);
        String[] arr1 = {"2:00 p.m", "6:00 p.m"};
        JComboBox<String> combo1 = new JComboBox<>(arr1);
        combo1.setBounds(200, 200, 40, 90);
        /*JLabel opinion1 = new JLabel(like);
        opinion1.setText("like");
        opinion1.setHorizontalTextPosition(opinion1.LEFT);
        opinion1.setVerticalTextPosition(opinion1.BOTTOM);
       //JLabel opinion2 = new JLabel("dislike.PNG");*/
        panel1.add(label1, BorderLayout.CENTER);
        panel1.add(combo1, BorderLayout.SOUTH);
        // panel1.add(opinion1);
        //  panel1.add(opinion2);
        ///// بانيل الفيلم الثاني 
        JPanel panel2 = new JPanel(new BorderLayout());


ImageIcon icon2 = new ImageIcon("missionimpossible.JPG");
        Image image2 = icon2.getImage();
        Image newicon2 = image2.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        icon2 = new ImageIcon(newicon2);
        JLabel label2 = new JLabel(icon2);
        label2.setText("Type : Action");
        label2.setHorizontalTextPosition(label2.CENTER);
        label2.setVerticalTextPosition(label2.BOTTOM);
        String[] arr2 = {"00:00", "4:00 p.m", "8:00 p.m"};
        JComboBox<String> combo2 = new JComboBox<>(arr2);
        combo2.setBounds(200, 200, 40, 90);
        panel2.add(label2, BorderLayout.CENTER);
        panel2.add(combo2, BorderLayout.SOUTH);
        container.add(panel1);
        container.add(panel2);
        showMoviePanel.add(panel1);
        showMoviePanel.add(panel2);
/////محتوى ال booking
        JLabel nameLabel = new JLabel();
        nameLabel.setText("chose your perfect time and movie: ");
        Font font1 = new Font("Arial", Font.PLAIN, 12);
        nameLabel.setFont(font1);
        nameLabel.setForeground(Color.WHITE);
        bookingPanel.add(nameLabel);
         String[] aa= new String[50];
            aa=displayAvailableSeatsforcomboBox();
            
        JComboBox namecombobox = new JComboBox(aa);
        namecombobox.setForeground(Color.WHITE);
        namecombobox.setBackground(new Color(0xBBD0FF));
        bookingPanel.setBackground(new Color(0x2F3E46));
        bookingPanel.add(namecombobox);

        JLabel bookLabel = new JLabel();
        bookLabel.setText("Press");
        bookLabel.setFont(font1);
        bookLabel.setForeground(Color.WHITE);
        bookingPanel.add(bookLabel);

        JButton bookButton = new JButton("OK");
        bookButton.setFocusable(false);
        bookButton.setBackground(new Color(0x354f52));
        bookButton.setForeground(Color.WHITE);
        bookingPanel.add(bookButton);
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
String selectedMovie = (String) namecombobox.getSelectedItem();
        String selectedTime = (String) combo1.getSelectedItem();

        BufferedWriter writer = null;
                try {
                    writer = new BufferedWriter(new FileWriter("temp.txt"));
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    writer.write(logIn.name + ", " + logIn.pass + ", " + selectedMovie + ", " + Count+", "+selectedTime);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    writer.newLine();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    writer.close();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
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

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

            @Override
            public void mouseClicked(MouseEvent e) {
                card.show(panel_R, "Show Movie");
                card.next(container);
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