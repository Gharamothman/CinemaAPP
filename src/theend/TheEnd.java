package theend;

import com.sun.tools.javac.Main;
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import static theend.Movie.readMoviesFromFile;

public class TheEnd {

    public static void main(String[] args) throws IOException {

        ////////  this isabout admin :
        /// object for user 
        User user1 = new User("gharam", "12345", "19", "Female");
        User user2 = new User("john_doe", "password123", "30", "Male");
        User user3 = new User("a", "1", "25", "Female");
        User user4 = new User("salam", "123", "60", "Male");
        User user5 = new User("kinan", "pas34", "10", "Male");
        User user6 = new User("abeer", "13683", "41", "Female");
        User user7 = new User("غرام", "12", "80", "Male");

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        userList.add(user6);
        userList.add(user7);

        Movie movie1 = new Movie("avatar", "avatar.JPG", new String[]{"12:00 PM", "3:00 PM"}, "Sci-Fi", 4.5);
        Movie movie3 = new Movie("Avengers", "avengers.JPG", new String[]{"3:00 PM", "6:00 PM"}, "Sci-Fi", 9.5);
        Movie movie4 = new Movie("The Conjuring", "conjuring.JPG", new String[]{"12:00 AM", "2:00 AM"}, "Horror", 7.8);
        Movie movie5 = new Movie("Jumanji", "jumanji.JPG", new String[]{"6:00 PM", "8:00 PM"}, "Adventure", 9.0);
        Movie movie6 = new Movie("The Fault in our Stars", "faultinourstars.JPG", new String[]{"7:00 PM", "9:00 PM"}, "Romance", 6.2);
        Movie movie7 = new Movie("Divergent", "divergent.JPG", new String[]{"6:00 PM", "9:00 PM"}, "Sci-Fi", 8.0);
        Movie movie8 = new Movie("Harry Potter", "harrypotter.JPG", new String[]{"2:00 PM", "5:00 PM"}, "Fantasy", 9.9);
        Movie movie9 = new Movie("The Hunger Games", "hungergames.JPG", new String[]{"8:00 PM", "10:00 PM"}, "Thriller", 8.6);
        Movie movie10 = new Movie("Titanic", "titanic.JPG", new String[]{"8:00 PM", "11:00 PM"}, "Drama", 9.6);

        final ArrayList<Movie> movieList = new ArrayList<>();
        movieList.add(movie1);
        movieList.add(movie3);
        movieList.add(movie4);
        movieList.add(movie5);
        movieList.add(movie6);
        movieList.add(movie7);
        movieList.add(movie8);
        movieList.add(movie9);                
        movieList.add(movie10);
        Movie.saveMoviesToFile("movies.dat", movieList);
       
        CinemaPhoto f = new CinemaPhoto("Cinema Photo.JPG", userList);

    }
    }


