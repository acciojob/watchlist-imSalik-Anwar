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
    HashMap<String, List<String>> movieDirPairDB = new HashMap<>();
    public String addMovie(Movie m) {
        movieDB.put(m.getName(), m);
        return "Movie added successfully!";
    }

    public String addDirector(Director d) {
        dirDB.put(d.getName(), d);
        return "Director added successfully!";
    }
    public String addMovieDirectorPair(String movieName, String dirName) {
        if(movieDirPairDB.containsKey(dirName)){
            List<String> oldList = movieDirPairDB.get(dirName);
            oldList.add(movieName);
        } else{
            List<String> newList = new ArrayList<>();
            newList.add(movieName);
            movieDirPairDB.put(dirName, newList);
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
        return movieDirPairDB.get(dirName);
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
            if(movieDirPairDB.containsKey(dirName)) {
                List<String> directorsMovies = movieDirPairDB.get(dirName);
                for (String m : directorsMovies) {
                    movieDB.remove(m);
                }
                movieDirPairDB.remove(dirName);
            }
            dirDB.remove(dirName);
            return "Director deleted successfully!";
        }
        return "Director does not exist";
    }

    public String deleteAllDirectors() {
        List<String> allDirectors = new ArrayList<>();
        for(String d : dirDB.keySet()){
            allDirectors.add(d);
        }
        dirDB.clear();
        for(String d : allDirectors){
            if(movieDirPairDB.containsKey(d)){
                List<String> movies = movieDirPairDB.get(d);
                for(String m : movies){
                    if(movieDB.containsKey(m)){
                        movieDB.remove(m);
                    }
                }
                movieDirPairDB.remove(d);
            }
        }
        return "All directors and their movies deleted successfully!";
    }
}
