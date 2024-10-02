
package com.mycompany.programming;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Map;
import javax.swing.*;

public class MovieFrame extends JFrame{
     Map<String, String> movies;

    public MovieFrame() {
        movies=readMoviesFromFile("movies.txt");
        setLayout(new GridLayout(3,4));
               
    }
     
    
}
