package com.mycompany.programming;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class Perfect {
   JPanel  homePanel;
    String nameMovie;
    static int Count = 0;
    static int price = 10;
    JLabel paylabel;

    public Perfect() {
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
        Image newicon1 = image1.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
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
        String[] arr2 = {"4:00 p.m", "8:00 p.m"};
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
        nameLabel.setText("Name of the movie:");
        Font font1 = new Font("Arial", Font.PLAIN, 12);
        nameLabel.setFont(font1);
        nameLabel.setForeground(Color.WHITE);
        bookingPanel.add(nameLabel);
     String[] arrmovie = {"null","Avatar","Mission Impossible"};
        JComboBox namecombobox = new JComboBox(arrmovie);
        namecombobox.setForeground(Color.WHITE);
        namecombobox.setBackground(new Color(0xBBD0FF));
        bookingPanel.setBackground(new Color(0x2F3E46));
        bookingPanel.add(namecombobox);
        namecombobox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             String selectedMovie = (String) namecombobox.getSelectedItem();
        updateHomePanel(selectedMovie);
                try{    BufferedWriter writer = new BufferedWriter(new FileWriter("user.txt", true));   
                writer.write("," +  selectedMovie);
                writer.newLine();           
                writer.close();
             }catch(IOException p){}      
         
            }

        });
        JLabel bookLabel = new JLabel();
        bookLabel.setText("Press OK to choose your seats");
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

                JFrame frame = new JFrame();
                JLabel title;
                JButton l[][], m[][], r[][];
                JPanel panel1, panel2, panel3;
                int x, y;

                title = new JLabel("Cinema Booking");
                title.setFont(new Font("Helvetica", Font.BOLD, 30));
                title.setLocation(12, 5);
                title.setSize(600, 60);
                frame.setLayout(null);
                l = new JButton[4][4];
                panel1 = new JPanel(new GridLayout(4, 4));
                panel1.setBackground(Color.black);
                panel1.setBounds(20, 70, 220, 140);
                for (y = 0; y < 4; y++) {
                    for (x = 0; x < 4; x++) {
                        l[x][y] = new JButton("L" + y + x);
                        l[x][y].setBackground(Color.WHITE);
                        l[x][y].setFocusable(false);
                        panel1.add(l[x][y]);
                        l[x][y].addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JButton button = (JButton) e.getSource();
                                toggleButtonState(button);
                            }
                        });
                    }
                }

                m = new JButton[4][4];
                panel2 = new JPanel(new GridLayout(4, 4));
                panel2.setBackground(Color.black);

                panel2.setBounds(250, 70, 250, 140);
                for (y = 0; y < 4; y++) {
                    for (x = 0; x < 4; x++) {
                        m[x][y] = new JButton("M" + y + x);
                        m[x][y].setBackground(Color.WHITE);
                        m[x][y].setFocusable(false);
                        panel2.add(m[x][y]);
                        m[x][y].addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JButton button = (JButton) e.getSource();
                                toggleButtonState(button);
                            }
                        });
                    }
                }

                r = new JButton[4][4];
                panel3 = new JPanel(new GridLayout(4, 4));
                panel3.setBackground(Color.black);
                panel3.setBounds(510, 70, 250, 140);
                for (y = 0; y < 4; y++) {
                    for (x = 0; x < 4; x++) {
                        r[x][y] = new JButton("R" + y + x);
                        r[x][y].setBackground(Color.WHITE);
                        r[x][y].setFocusable(false);
                        panel3.add(r[x][y]);
                        r[x][y].addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JButton button = (JButton) e.getSource();
                                toggleButtonState(button);
                                System.out.println(Count);
                            }
                        });
                    }
                }

                frame.add(title);
                frame.add(panel1);
                frame.add(panel2);
                frame.add(panel3);
                JButton bookbutton = new JButton();
                bookbutton.setText("Done!");
                bookbutton.setBackground(Color.BLACK);
                bookbutton.setBounds(40, 250, 80, 50);
                bookbutton.setFocusable(false);
                bookbutton.setForeground(Color.white);
                frame.add(bookbutton);
                JLabel paylabel = new JLabel();
                paylabel.setFont(new Font("Helvetica", Font.ITALIC, 16));
                paylabel.setBounds(150, 250, 200, 50);
                JLabel waypay = new JLabel("How you want pay?");
                waypay.setFont(new Font("Helvetica", Font.BOLD, 14));
                waypay.setBounds(40, 300, 200, 50);
                frame.add(waypay);
                JCheckBox cash = new JCheckBox("cash");
                cash.setBounds(60, 350, 200, 30);
                JCheckBox card = new JCheckBox("gridat card");
                card.setBounds(60, 380, 200, 30);
                ButtonGroup buttonGroup = new ButtonGroup();
                buttonGroup.add(cash);
                buttonGroup.add(card);
                frame.add(card);
                frame.add(cash);

                bookbutton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (paylabel != null) {
                            frame.remove(paylabel);
                            frame.revalidate();
                            frame.repaint();
                        }
                        paylabel.setText("Total Price is : " + Count * price + "$");
                        frame.add(paylabel);
                        frame.revalidate();
                        frame.repaint();

                    }
                });

                frame.setPreferredSize(new Dimension(900, 500));
                frame.setTitle("Cinema Booking");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack(); //sets appropriate size for frame
                frame.setVisible(true);

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
        ////محتوى باني home
        Font font = new Font("Edwardian Script", Font.ITALIC, 18);
        JLabel user = new JLabel("your name: " + logIn.name);
        user.setBounds(90, 20, 200, 80);
        user.setFont(font);
        homePanel.add(user);
        JLabel ticket = new JLabel("your ticket: " + Count);
        ticket.setBounds(90, 60, 200, 80);
        ticket.setFont(font);
        homePanel.add(ticket);
        JLabel film = new JLabel("name of movie: " + (String) namecombobox.getSelectedItem());
        film.setBounds(90, 100, 200, 80);
        film.setFont(font);
        homePanel.add(film);

        frame.setVisible(true);
    }

    public void toggleButtonState(JButton button) {
        Color originalColor = button.getBackground();
        Color newColor = originalColor.equals(Color.RED) ? Color.BLACK : Color.RED;
        button.setBackground(newColor);

        if (newColor.equals(Color.RED)) {
            Count++;
        } else {
            button.setBackground(Color.WHITE);
            Count--;
        }

        System.out.println("عدد المقاعد المحجوزة: " + Count);
    }
   
   
  

// دالة لتحديث العناصر في HomePanel بناءً على الفيلم المختار
private void updateHomePanel(String selectedMovie) {
    Font font = new Font("Edwardian Script", Font.ITALIC, 18);
    JLabel user = new JLabel("your name: " + logIn.name);
    user.setBounds(90, 20, 200, 80);
    user.setFont(font);
    homePanel.add(user);

    JLabel ticket = new JLabel("your ticket: " + Count);
    ticket.setBounds(90, 60, 200, 80);
    ticket.setFont(font);
    homePanel.add(ticket);

    JLabel film = new JLabel("name of movie: " + selectedMovie);
    film.setBounds(90, 100, 200, 80);
    film.setFont(font);
    homePanel.add(film);

    // إعادة رسم HomePanel
    homePanel.revalidate();
    homePanel.repaint();
}

}
