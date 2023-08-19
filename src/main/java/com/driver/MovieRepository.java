package com.driver;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class MovieRepository {
    HashMap<String, Movie> movieDB = new HashMap<>();
    HashMap<String, Director> dirDB = new HashMap<>();
    HashMap<String, List<String>> movieDirPair = new HashMap<>();
    public String addMovie(Movie m) {
        movieDB.put(m.getName(), m);
        return "Movie added successfully!";
    }

    public String addDirector(Director d) {
        dirDB.put(d.getName(), d);
        return "Director added successfully!";
    }
    public String addMovieDirectorPair(String movieName, String dirName) {
        if(movieDirPair.containsKey(dirName)){
            List<String> oldList = movieDirPair.get(dirName);
            oldList.add(movieName);
        } else{
            List<String> newList = new ArrayList<>();
            newList.add(movieName);
            movieDirPair.put(dirName, newList);
        }
        return "Movie-director pair added successfully!";
    }
    public Movie getMovieByName(String movieName) {
        return movieDB.get(movieName);
    }

    public Director getDirectorByName(String dirName) {
        return dirDB.get(dirName);
    }


    public List<String> getMoviesByDirectorName(String dirName) {
        return movieDirPair.get(dirName);
    }

    public List<String> findAllMovies() {
        List<String> allMovies = new ArrayList<>();
        for(String m : movieDB.keySet()){
            allMovies.add(m);
        }
        return allMovies;
    }

    public String deleteDirectorByName(String dirName) {
        if(dirDB.containsKey(dirName)){
            dirDB.remove(dirName);
            return "Director deleted successfully!";
        }
        return "Director does not exist";
    }

    public String deleteAllDirectors() {
        movieDirPair.clear();
        return "All directors deleted successfully!";
    }
}
