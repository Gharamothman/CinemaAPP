package theend;

import java.util.ArrayList;
import java.util.List;

public class Cinema {

    private String hallName;
    private List<Movie> movies;
    //// this is about constructer :
    public Cinema(String hallName) {
        this.hallName = hallName;
        this.movies = new ArrayList<>();
    }
/// this is about getter and settre:
    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public List<Movie> getMovies() {
        return movies;
    }
  //// to add a list of movie 
    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
   //// to add amovie 
    public void addMovie(Movie movie) {
        movies.add(movie);
    }
  /// show us the avaliabel movie 
    public void displayMovies() {
        System.out.println("Movies in " + hallName + ":");
        for (Movie movie : movies) {
            System.out.println("  - " + movie.getName());
        }
    }
    
}
