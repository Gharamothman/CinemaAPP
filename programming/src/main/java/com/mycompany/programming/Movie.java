
package com.mycompany.programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;


public class Movie {
   String name;
   String time ;
   static int seat= 96;
      Vector<String> nameMovies = new Vector<>();
       
      Vector<String> timemovie = new Vector<>();
         
    public Movie(String name, String time) {
        this.name = name;
        this.time = time;
         nameMovies.add(name);
        timemovie.add(time);
    }
      
    
  
   
public void saveInfile(){
   
 try {
            BufferedReader reader = new BufferedReader(new FileReader("movie.txt"));       
            String line;
            boolean userExists = false;        
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(", ");     
                if (data[0].equals(name) && data[1].equals(time)) {
                    userExists = true;             
                    break;
                }            }
            reader.close();     
            if (!userExists) {
                BufferedWriter writer = new BufferedWriter(new FileWriter("movie.txt", true));   
                  writer.write( name+","+time+","+seat);
           
                writer.newLine();           
                writer.close();
            }        } catch (IOException e) {
            e.printStackTrace();        }
    }



}
   
                   


