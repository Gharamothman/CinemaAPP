package theend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static theend.Movie.readMoviesFromFile;

public class ShowMovie extends JFrame {

    private List<Movie> movies;
    private int currentIndex;
    private JLabel titleLabel;
    private JLabel genreLabel;
    private JLabel ratingLabel;
    private JLabel imageLabel;
    private JLabel hLabel;

    public ShowMovie() {
        movies = readMoviesFromFile();
        currentIndex = 0;
        initializeUI();
        displayCurrentMovie();
    }

    private void initializeUI() {
        ImageIcon key = new ImageIcon("show.PNG");
        setIconImage(key.getImage());
        setVisible(true);
        setSize(420, 420);
        setTitle("Show Movie");
        setLocation(500, 200);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel infoPanel = new JPanel(new GridLayout(4, 1));
        infoPanel.setBackground(new Color(0x5D4E9C));
        Font font2 = new Font("Monotype Corsive", Font.ITALIC, 16);
        titleLabel = new JLabel();
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(font2);
        genreLabel = new JLabel();
        genreLabel.setFont(font2);
        genreLabel.setForeground(Color.WHITE);
        ratingLabel = new JLabel();
        ratingLabel.setFont(font2);
        ratingLabel.setForeground(Color.WHITE);
        hLabel = new JLabel();
        hLabel.setForeground(Color.WHITE);
        hLabel.setFont(font2);
        infoPanel.add(titleLabel);
        infoPanel.add(genreLabel);
        infoPanel.add(ratingLabel);
        infoPanel.add(hLabel);

        imageLabel = new JLabel();

        add(imageLabel, BorderLayout.CENTER);
        add(infoPanel, BorderLayout.SOUTH);

        JButton nextButton = new JButton(">");
        nextButton.setFocusable(false);

        nextButton.setBackground(new Color(0x5D4E9C));
        nextButton.setBounds(10, 300, 385, 25);
        nextButton.setForeground(Color.white);
        nextButton.setBorder(BorderFactory.createLineBorder(new Color(0x5D4E9C), 5));
        nextButton.addActionListener(e -> showNextMovie());
        add(nextButton, BorderLayout.EAST);

        JButton prevButton = new JButton("<");
        prevButton.setFocusable(false);

        prevButton.setBackground(new Color(0x5D4E9C));
        prevButton.setBounds(10, 300, 385, 25);
        prevButton.setForeground(Color.white);
        prevButton.setBorder(BorderFactory.createLineBorder(new Color(0x5D4E9C), 5));
        prevButton.addActionListener(e -> showPreviousMovie());
        add(prevButton, BorderLayout.WEST);
        Font font1 = new Font("Monotype Corsive", Font.ITALIC, 12);
        JButton backButton = new JButton("Back to Main");
        backButton.setFocusable(false);
        backButton.setFont(font1);
        backButton.setBackground(new Color(0x5D4E9C));
        backButton.setForeground(Color.white);
        backButton.setBorder(BorderFactory.createLineBorder(new Color(0x5D4E9C), 5));
        backButton.addActionListener(e -> goBackToMain());
        add(backButton, BorderLayout.NORTH);
        getContentPane().setBackground(new Color(0x5D4E9C));
    }

    private void showNextMovie() {
        currentIndex = (currentIndex + 1) % movies.size();
        displayCurrentMovie();
    }

    private void showPreviousMovie() {
        currentIndex = (currentIndex - 1 + movies.size()) % movies.size();
        displayCurrentMovie();
    }

    private void displayCurrentMovie() {
        Movie currentMovie = movies.get(currentIndex);

        titleLabel.setText("                                  Title:  " + currentMovie.getName());
        genreLabel.setText("                                  Genre: " + currentMovie.getGenre());
        ratingLabel.setText("                                 Rating: " + currentMovie.getRating());
        hLabel.setText(" ____________________________________________");
        ImageIcon imageIcon = new ImageIcon(currentMovie.getImagePath());
        Image image = imageIcon.getImage().getScaledInstance(450, 250, Image.SCALE_DEFAULT);
        imageIcon = new ImageIcon(image);
        imageLabel.setIcon(imageIcon);
    }

    private void goBackToMain() {
        new Option();
    }

}
