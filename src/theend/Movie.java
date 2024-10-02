package theend;

import java.io.*;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.List;
public class Movie implements Serializable{

    private String name;
    private String imagePath;
    private String[] showTimes;
    private String genre;
    private double rating;

    //// this is about constructer:
    public Movie(String name, String imagePath, String[] showTimes, String genre, double rating) {
        this.name = name;
        this.imagePath = imagePath;
        this.showTimes = showTimes;
        this.genre = genre;
        this.rating = rating;
    }
    
    /// this is about store infor about movie in objectfile 

    public static void saveMoviesToFile(String fileName, List<Movie> movies) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
        for (Movie movie : movies) {
            oos.writeUnshared(movie);
        }
    } catch (IOException e) {
        System.out.println("something happen when we write in movie file");
    }
}
/// this is about read info from object file 

    public static ArrayList<Movie> readMoviesFromFile() {
        ArrayList<Movie> movies = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("movies.dat"))) {
            while (true) {
                try {
                    Movie movie = (Movie) ois.readObject();
                    movies.add(movie);
                } catch (EOFException e) {
                                  break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return movies;
    }
///// this is about gettre and setter

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getShowTimes() {
        return showTimes;
    }

    public void setShowTimes(String[] showTimes) {
        this.showTimes = showTimes;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    

}
