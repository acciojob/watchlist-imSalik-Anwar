package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;


    public String addMovie(Movie m){
        return movieRepository.addMovie(m);
    }

    public String addDirectro(Director d) {
        return movieRepository.addDirector(d);
    }
    public String addMovieDirectorPair(String movieName, String dirName) {
        return movieRepository.addMovieDirectorPair(movieName, dirName);
    }
    public Movie getMovieByName(String movieName) {
        return movieRepository.getMovieByName(movieName);
    }

    public Director getDirectorByName(String dirName) {
        return movieRepository.getDirectorByName(dirName);
    }

    public List<String> getMoviesByDirectorName(String dirName) {
        return movieRepository.getMoviesByDirectorName(dirName);
    }

    public List<String> findAllMovies() {
        return movieRepository.findAllMovies();
    }

    public String deleteDirectorByName(String dirName) {
        return movieRepository.deleteDirectorByName(dirName);
    }

    public String deleteAllDirectors() {
        return movieRepository.deleteAllDirectors();
    }
}
