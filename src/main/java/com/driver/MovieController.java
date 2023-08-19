package com.driver;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/POST/movies/add-movie")
    public String addMovie(@RequestBody Movie m){
        return movieService.addMovie(m);
    }
    @PostMapping("/POST/movies/add-director")
    public String addDirector(@RequestBody Director d){
        return movieService.addDirectro(d);
    }
    @PostMapping("/POST/movies/add-movie-director-pair")
    public String addMovieDirectorPair(@RequestParam("mname") String movieName, @RequestParam("dname") String dirName){
        return movieService.addMovieDirectorPair(movieName, dirName);
    }
    @GetMapping("/GET/movies/get-movie-by-name/{name}")
    public Movie getMovieByName(@PathVariable("name") String movieName){
        return movieService.getMovieByName(movieName);
    }
    @GetMapping("/GET/movies/get-director-by-name/{name}")
    public Director getDirectorByName(@PathVariable("name") String dirName){
        return movieService.getDirectorByName(dirName);
    }
    @GetMapping("/GET/movies/get-movies-by-director-name/{director}")
    public List<String> getMoviesByDirectorName(@PathVariable("director") String dirName){
        return movieService.getMoviesByDirectorName(dirName);
    }
    @GetMapping("/GET/movies/get-all-movies")
    public List<String> findAllMovies(){
        return movieService.findAllMovies();
    }
    @DeleteMapping("/DELETE/movies/delete-director-by-name")
    public String deleteDirectorByName(@RequestParam("director") String dirName){
        return movieService.deleteDirectorByName(dirName);
    }
    @DeleteMapping("/DELETE/movies/delete-all-directors")
    public String deleteAllDirectors(){
        return movieService.deleteAllDirectors();
    }
}
