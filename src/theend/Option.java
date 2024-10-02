package theend;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public  class Option {

    JPanel panel;

    public Option() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(420, 420);
        frame.setTitle("Main");
        frame.setLocation(500, 200);
        frame.setResizable(false);
        frame.setLayout(new GridLayout(4, 1));

        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        String[] buttonTexts = {"Account", "Show Movie", "Booking", "Home"};
        for (int i = 0; i < 4; i++) {
            int color = (i % 2 == 0) ? 0x5D4E9C : 0x3D3f9C;
            JPanel panel = createPanel("Panel " + (i + 1), color);

            JButton button = createButton(buttonTexts[i], color);
            panel.add(button);

            frame.add(panel);
        }
    }

    private static JPanel createPanel(String panelName, int color) {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("****"));
        panel.setBackground(new Color(color));

        return panel;
    }

    private static JButton createButton(String buttonText, int color) {
        JButton button = new JButton(buttonText);
        button.setFocusable(false);
        button.setFont(new Font("Monotype Corsive", Font.ITALIC, 25));
        button.setBackground(new Color(color));
        button.setForeground(Color.white);
        button.setBorder(BorderFactory.createLineBorder(new Color(color), 5));
         button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
             if(buttonText.equals("Account"))  {
                 new Account();
             }    
             if(buttonText.equals("Show Movie")){
                 new ShowMovie();
             }
             if(buttonText.equals( "Booking"))  {
                 try {
                     new BookingTicket();
                 } catch (IOException ex) {
                     Logger.getLogger(Option.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }    
             if(buttonText.equals("Home")){
                 new Home();
             }
            }
        });
        return button;
    }

   
}