package theend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.border.Border;

import theend.Movie;
import theend.Option;
import theend.Ticketing;

public class BookingTicket {

    private JFrame frame;
    private JComboBox<String> moviesComboBox;
    private JComboBox<Integer> seatsComboBox;
    private JButton reserveButton;
    private JButton cancelButton;
    private JTextField payTextField;
    private JTextField waysOfPayTextField;
    private JLabel priceLabel;
    private JRadioButton cash;
    private JRadioButton card;
    private boolean dataSelected = false;
    private ArrayList<Movie> movies;
    private Ticketing t;
    static int price = 10;
    private ButtonGroup paymentMethodGroup;
    private JRadioButton cashRadioButton;
    private JRadioButton creditCardRadioButton;

    public BookingTicket() throws IOException {
        t = new Ticketing();
        this.movies = Movie.readMoviesFromFile();

        frame = new JFrame();
        frame.setSize(420, 420);
        frame.setTitle("Booking Ticket");
        frame.setLocation(500, 200);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon key = new ImageIcon("ticket.PNG");
        frame.setIconImage(key.getImage());

        Font font2 = new Font("Monotype Corsive", Font.ITALIC, 14);

        JButton button = new JButton();
        button.setText(" >> ");
        button.setFocusable(false);
        button.setFont(font2);
        button.setBackground(new Color(0x3D3f9C));
        button.setBounds(350, 15, 40, 25);
        button.setForeground(Color.white);
        button.setBorder(BorderFactory.createLineBorder(new Color(0x3D3f9C), 5));
        frame.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Option();
            }
        });

        moviesComboBox = createComboBoxs(20, 50, 200, 30, Color.WHITE, new Color(0x3D3f9C), new ArrayList<>());
        moviesComboBox.addItem("Select a movie");
        fillMoviesComboBox(movies);
        frame.add(moviesComboBox);

        seatsComboBox = createComboBox(240, 50, 150, 30, Color.WHITE, new Color(0x3D3f9C), new ArrayList<>());
        seatsComboBox.addItem(0); 
       
        fillSeatsComboBox();
        frame.add(seatsComboBox);
        JLabel paylabel = new JLabel();
        paylabel.setFont(new Font("Helvetica", Font.ITALIC, 12));
        paylabel.setBounds(20, 190, 150, 40);

        reserveButton = createStyledButton("Reserve", 20, 110, 100, 30, font2);
        reserveButton.setEnabled(false);  // Initially set to disabled
        reserveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You are reserving");
                t.bookSeat(LogeInManger.name, (String) moviesComboBox.getSelectedItem(), (int) seatsComboBox.getSelectedItem());
                JButton bookbutton = createStyledButton("the price of reserve and pay ways : ", 20, 160, 250, 30, font2);
                 bookbutton.setFocusable(false);
                frame.add(bookbutton);
             
                if (paylabel != null) {
                    frame.remove(paylabel);
                    frame.revalidate();
                    frame.repaint();
                }
                int totalprice = (int) seatsComboBox.getSelectedItem() * price;
                paylabel.setForeground(Color.WHITE);
                paylabel.setText("Total Price is : " + totalprice + "$");
                frame.add(paylabel);
                frame.revalidate();
                frame.repaint();

                paymentMethodGroup = new ButtonGroup();
                              cashRadioButton = new JRadioButton("Cash");
                cashRadioButton.setBounds(20, 220, 150, 40);
                cashRadioButton.setBackground(new Color(0x5D4E9C));
                cashRadioButton.setForeground(Color.white);
                frame.add(cashRadioButton);
                paymentMethodGroup.add(cashRadioButton);

                creditCardRadioButton = new JRadioButton("Credit Card");
                creditCardRadioButton.setBounds(20, 250, 150, 40);
                creditCardRadioButton.setBackground(new Color(0x5D4E9C));
                creditCardRadioButton.setForeground(Color.white);
                frame.add(creditCardRadioButton);
                paymentMethodGroup.add(creditCardRadioButton);
                cashRadioButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        showMessageBox("You can pay in cash upon arrival.", "Payment Method", JOptionPane.INFORMATION_MESSAGE);
                    }
                });

                creditCardRadioButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        showMessageBox("You can pay by credit card. Use the following code: XXXX-XXXX-XXXX-XXXX", "Payment Method", JOptionPane.INFORMATION_MESSAGE);
                    }
                });

            }
        });
        frame.add(reserveButton);

        cancelButton = createStyledButton("Cancel Reservation", 150, 110, 150, 30, font2);
        cancelButton.setEnabled(false);  // Initially set to disabled
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("cancel");
                t.cancelBooking(LogeInManger.name, (String) moviesComboBox.getSelectedItem(), (int) seatsComboBox.getSelectedItem());
                UserBooking ue = new UserBooking(LogeInManger.name, (String) moviesComboBox.getSelectedItem(), (int) seatsComboBox.getSelectedItem());
                int seat = ue.getTicketCount();
                if (paylabel != null) {
                    frame.remove(paylabel);
                    frame.revalidate();
                    frame.repaint();
                }

                int totalprice = seat * price;
                paylabel.setForeground(Color.WHITE);
                paylabel.setText("Total Price is : " + totalprice + "$");
                frame.add(paylabel);
                frame.revalidate();
                frame.repaint();
            }
        });
        frame.add(cancelButton);

        ImageIcon image1 = new ImageIcon("booking.PNG");
        JLabel imageLabel = new JLabel(image1);
        imageLabel.setBounds(250, 180, 150, 150);
        frame.add(imageLabel);

        frame.getContentPane().setBackground(new Color(0x5D4E9C));
        frame.setVisible(true);
    }

    private void fillMoviesComboBox(ArrayList<Movie> movies) {
        for (Movie movie : movies) {
            for (String showTime : movie.getShowTimes()) {
                String fullMovieName = movie.getName() + " - " + showTime;
                moviesComboBox.addItem(fullMovieName);
            }
        }

        moviesComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enableButtons();
                fillSeatsComboBox();
            }
        });
    }

    private void enableButtons() {
        reserveButton.setEnabled(true);
        cancelButton.setEnabled(true);
    }

    private void fillSeatsComboBox() {
        seatsComboBox.removeAllItems();
        for (int i = 1; i <= 10; i++) {
            seatsComboBox.addItem(i);
        }
    }

    private JButton createStyledButton(String text, int x, int y, int width, int height, Font font) {
        JButton button = new JButton();
        button.setText(text);
        button.setFocusable(false);
        button.setFont(font);
        button.setBackground(new Color(0x3D3f9C));
        button.setBounds(x, y, width, height);
        button.setForeground(Color.white);
        button.setBorder(BorderFactory.createLineBorder(new Color(0x3D3f9C), 5));
        return button;
    }

    private JComboBox<Integer> createComboBox(int x, int y, int width, int height, Color foreground, Color background, ArrayList<Integer> items) {
        JComboBox<Integer> comboBox = new JComboBox<>(items.toArray(new Integer[0]));
        comboBox.setBounds(x, y, width, height);
        comboBox.setForeground(foreground);
        comboBox.setBackground(background);
        return comboBox;
    }

    private JComboBox<String> createComboBoxs(int x, int y, int width, int height, Color foreground, Color background, ArrayList<String> items) {
        JComboBox<String> comboBox = new JComboBox<>(items.toArray(new String[0]));
        comboBox.setBounds(x, y, width, height);
        comboBox.setForeground(foreground);
        comboBox.setBackground(background);
        return comboBox;
    }

    private void showMessageBox(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(frame, message, title, messageType);
    }
}
