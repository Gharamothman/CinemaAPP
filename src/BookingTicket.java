import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.border.Border;
import theend.Movie;

public class BookingTicket {
    private JFrame frame;
    private JComboBox<String> moviesComboBox;
    private JComboBox<String> timesComboBox;
    private JComboBox<Integer> seatsComboBox;
    private JButton reserveButton;
    private JButton cancelButton;
    private JTextField payTextField;
    private JTextField waysOfPayTextField;
    private JLabel priceLabel;
    private JRadioButton cash;
    private JRadioButton card;
    private boolean dataSelected = false;
  static ArrayList<Movie> movies;
    public BookingTicket(ArrayList<Movie> movies) {
       this .  movies=movies;
        frame = new JFrame();
        frame.setSize(420, 420);
        frame.setTitle("Booking Ticket");
        frame.setLocation(500, 200);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font2 = new Font("Monotype Corsive", Font.ITALIC, 14);

        JLabel titleLabel = createStyledLabel("Movie Reservation", 150, 10, 200, 30, font2);
        frame.add(titleLabel);

        moviesComboBox = createComboBoxs(20, 50, 200, 30, Color.WHITE, new Color(0x3D3f9C), new ArrayList<>());
        moviesComboBox.addItem("Select a movie");
        fillMoviesComboBox(movies);
        moviesComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTimesComboBox();

                dataSelected = true;
                enableButtons();
            }
        });
        frame.add(moviesComboBox);

        timesComboBox = createComboBoxs(240, 50, 150, 30, Color.WHITE, new Color(0x3D3f9C), new ArrayList<>());
        timesComboBox.addItem("Select a time");
        frame.add(timesComboBox);

seatsComboBox = createComboBox(20, 90, 70, 30, Color.WHITE, new Color(0x3D3f9C), new ArrayList<>());
        seatsComboBox.addItem(0);  // Add a default value
        fillSeatsComboBox();
        frame.add(seatsComboBox);

        reserveButton = createStyledButton("Reserve", 20, 130, 100, 30, font2);
        reserveButton.setEnabled(false);  // Initially set to disabled
        reserveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reserveAction();
            }
        });
        frame.add(reserveButton);

        cancelButton = createStyledButton("Cancel Reservation", 140, 130, 150, 30, font2);
        cancelButton.setEnabled(false);  // Initially set to disabled
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelAction();
            }
        });
        frame.add(cancelButton);

        payTextField = createStyledTextField("Number of Tickets: 0", 20, 180, 200, 30, font2);
        frame.add(payTextField);

        waysOfPayTextField = createStyledTextField("Ways of Pay:", 20, 220, 200, 30, font2);
        frame.add(waysOfPayTextField);

        priceLabel = createStyledLabel("Ticket Price: $10", 20, 260, 200, 30, font2);
        frame.add(priceLabel);

        cash = createRadioButton("Cash", 20, 300, 100, 30, font2);
        card = createRadioButton("Credit card", 130, 300, 150, 30, font2);
        cash.setEnabled(false);
        card.setEnabled(false);
        frame.add(cash);
        frame.add(card);

        cash.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Reservation successful! You can pay when you arrive.");
            }
        });

        card.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Reservation successful! You can send the amount to our account.");
            }
        });

        ButtonGroup paymentGroup = new ButtonGroup();
        paymentGroup.add(cash);
        paymentGroup.add(card);

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
    }

    private void fillSeatsComboBox() {
        for (int i = 1; i <= 20; i++) {
            seatsComboBox.addItem(i);
        }
    }

   private void updateTimesComboBox() {
    String selectedMovie = (String) moviesComboBox.getSelectedItem();
    timesComboBox.removeAllItems();
    timesComboBox.addItem("Select a time");  // Add a default value

    for (Movie movie : movies) {
        String movieName = movie.getName();
        String[] showTimes = movie.getShowTimes();

        if (selectedMovie.startsWith(movieName)) {
            for (String showTime : showTimes) {
                timesComboBox.addItem(showTime);
            }
            break;
        }
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
private JComboBox<Integer> createComboBox(int x, int y, int width, int height, Color foreground, Color background, List<Integer> items) {
        JComboBox<Integer> comboBox = new JComboBox<>(items.toArray(new Integer[0]));
        comboBox.setBounds(x, y, width, height);
        comboBox.setForeground(foreground);
        comboBox.setBackground(background);
        return comboBox;
    }

    private JComboBox<String> createComboBoxs(int x, int y, int width, int height, Color foreground, Color background, List<String> items) {
        JComboBox<String> comboBox = new JComboBox<>(items.toArray(new String[0]));
        comboBox.setBounds(x, y, width, height);
        comboBox.setForeground(foreground);
        comboBox.setBackground(background);
        return comboBox;
    }

    private JTextField createStyledTextField(String text, int x, int y, int width, int height, Font font) {
        JTextField textField = new JTextField(text);
        Border emptyBorder = BorderFactory.createEmptyBorder();
        textField.setBorder(emptyBorder);
        textField.setFont(font);
        textField.setForeground(Color.WHITE);
        textField.setBounds(x, y, width, height);
        textField.setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, new Color(0x5D4E9C)));
        textField.setFocusable(false);
        textField.setBackground(new Color(0x3D3f9C));
        return textField;
    }

    private JRadioButton createRadioButton(String text, int x, int y, int width, int height, Font font) {
        JRadioButton radioButton = new JRadioButton(text);
        radioButton.setBackground(new Color(0x3D3f9C));
        radioButton.setFont(font);
        radioButton.setForeground(Color.WHITE);
        radioButton.setBounds(x, y, width, height);
        radioButton.setFocusable(false);
        return radioButton;
    }

    private JLabel createStyledLabel(String text, int x, int y, int width, int height, Font font) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(Color.WHITE);
        label.setBounds(x, y, width, height);
        label.setVisible(true);
        return label;
    }

    private void enableButtons() {
        reserveButton.setEnabled(true);
        cancelButton.setEnabled(true);
    }

    private void reserveAction() {
        if (dataSelected) {
            String selectedMovie = (String) moviesComboBox.getSelectedItem();
            String selectedTime = (String) timesComboBox.getSelectedItem();
            int selectedSeats = (int) seatsComboBox.getSelectedItem();

            if (!selectedMovie.equals("Select a movie") && !selectedTime.equals("Select a time") && selectedSeats > 0) {
                // Handle reservation logic here
                // Update the payTextField with the number of tickets
                payTextField.setText("Number of Tickets: " + selectedSeats);

                // Enable payment details
                waysOfPayTextField.setText("Ways of Pay:");
                priceLabel.setVisible(true);
                cash.setEnabled(true);
                card.setEnabled(true);

                // Show the reserve and cancel buttons
                reserveButton.setVisible(true);
                cancelButton.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(frame, "Please select valid data.");
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Please select data first.");
        }
    }

    private void cancelAction() {
        // Handle cancellation logic here
        int canceledSeats = (int) seatsComboBox.getSelectedItem();
        JOptionPane.showMessageDialog(frame, "Reservation canceled for " + canceledSeats + " tickets.");

        // Reset the UI
        resetUI();
    }

    private void resetUI() {
        moviesComboBox.setSelectedIndex(0);
        timesComboBox.setSelectedIndex(0);
        seatsComboBox.setSelectedIndex(0);
        payTextField.setText("Number of Tickets: 0");
        waysOfPayTextField.setText("Ways of Pay:");
        priceLabel.setVisible(false);
        cash.setEnabled(false);
        card.setEnabled(false);
        reserveButton.setVisible(false);
        cancelButton.setVisible(false);
        dataSelected = false;
    }
}
