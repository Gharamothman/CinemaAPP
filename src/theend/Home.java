package theend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.border.Border;

public class Home {

    int dislike = 0;
    int like = 0; 
    JTextArea textArea;
    JTextField textFieldLike;
    JTextField textFieldDislike;

    public Home() {
        ImageIcon key = new ImageIcon("comment.PNG");

        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setIconImage(key.getImage());
        frame.setSize(420, 420);
        frame.setTitle("Home");
        frame.setLocation(500, 200);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon image1 = new ImageIcon("drink1.PNG");
        JLabel l = new JLabel(image1);
        l.setBounds(0, 0, 600, 600);
        frame.add(l);

        JTextField textField = new JTextField(" Enter your comment:  ");
        Border emptyBorder = BorderFactory.createEmptyBorder();
        textField.setBorder(emptyBorder);
        frame.add(textField);
        Font font3 = new Font("Monotype Corsive", Font.ITALIC, 13);
        textField.setFont(font3);
        textField.setForeground(Color.WHITE);
        textField.setBounds(100, 10, 220, 20);
        textField.setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, new Color(0x5D4E9C)));
        textField.setFocusable(false);
        textField.setBackground(new Color(0x3D3f9C));

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBounds(100, 30, 220, 30);
        textArea.setBackground(new Color(0x3D3f9C));
        frame.add(textArea);

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

        JButton button3 = new JButton();
        button3.setText("Submit Your Comment");
        button3.setFocusable(false);
        button3.setFont(font3);
        button3.setBackground(new Color(0x3D3f9C));
        button3.setBounds(50, 90, 300, 25);
        button3.setForeground(Color.white);
        button3.setBorder(BorderFactory.createLineBorder(new Color(0x3D3f9C), 5));
        frame.add(button3);

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveComment(textArea.getText());
                textArea.setText("");
            }
        });
        JButton likebutton = new JButton();
        likebutton.setText("Like");
        likebutton.setFocusable(false);
        likebutton.setFont(font3);
        likebutton.setBackground(new Color(0x3D3f9C));
        likebutton.setBounds(30, 270, 120, 30);
        likebutton.setForeground(Color.white);
        likebutton.setBorder(BorderFactory.createLineBorder(new Color(0x3D3f9C), 5));
        frame.add(likebutton);
        likebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                like++;
                textFieldLike.setText(String.valueOf(like));
                saveLikesDislikes();
            }
        });
        textFieldLike = new JTextField("0");
        textFieldLike.setBorder(emptyBorder);
        textFieldLike.setFont(font3);
        textFieldLike.setForeground(Color.BLACK);
        textFieldLike.setBounds(160, 275, 25, 25);
        textFieldLike.setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, new Color(0x5D4E9C)));
        textFieldLike.setFocusable(false);
        textFieldLike.setBackground(new Color(0x3D3f9C));
        frame.add(textFieldLike);

        JButton dislikebutton = new JButton();
        dislikebutton.setText("Dislike");
        dislikebutton.setFocusable(false);
        dislikebutton.setFont(font3);
        dislikebutton.setBackground(new Color(0x3D3f9C));
        dislikebutton.setBounds(30, 320, 120, 30);
        dislikebutton.setForeground(Color.white);
        dislikebutton.setBorder(BorderFactory.createLineBorder(new Color(0x3D3f9C), 5));
        frame.add(dislikebutton);
        dislikebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dislike++;
                textFieldDislike.setText(String.valueOf(dislike));
                saveLikesDislikes();
            }
        });

        textFieldDislike = new JTextField("0");
        textFieldDislike.setBorder(emptyBorder);
        textFieldDislike.setFont(font3);
        textFieldDislike.setForeground(Color.BLACK);
        textFieldDislike.setBounds(160, 323, 25, 25);
        textFieldDislike.setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, new Color(0x5D4E9C)));
        textFieldDislike.setFocusable(false);
        textFieldDislike.setBackground(new Color(0x3D3f9C));
        frame.getContentPane().setBackground(new Color(0x5D4E9C));
        frame.add(textFieldDislike);
        loadLikesDislikes();

    }

    private void saveComment(String comment) {
        // Check if the comment has more than 5 words
        if (countWords(comment) > 5) {
            System.out.println("Comment should not exceed 5 words.");
            return;
        }

        try (BufferedWriter file = new BufferedWriter(new FileWriter("comments.txt", true))) {
            file.write(comment);
            file.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private int countWords(String text) {
        String[] words = text.trim().split("\\s+");
        return words.length;
    }

    private void saveLikesDislikes() {
        try (BufferedWriter file = new BufferedWriter(new FileWriter("likes_dislikes.txt"))) {
            file.write("Like: " + like );
                        file.newLine();
            file.write("Dislike: " + dislike );
                        file.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void loadLikesDislikes() {
        try (BufferedReader reader = new BufferedReader(new FileReader("likes_dislikes.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Like: ")) {
                    like = Integer.parseInt(line.substring(6));
                    textFieldLike.setText(String.valueOf(like));
                } else if (line.startsWith("Dislike: ")) {
                    dislike = Integer.parseInt(line.substring(9));
                    textFieldDislike.setText(String.valueOf(dislike));
                }
            }
        } catch (IOException | NumberFormatException ex) {
            ex.printStackTrace();
        }
    }

}
