package com.driver;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/POST/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie m){
//        return movieService.addMovie(m);
        return new ResponseEntity<>(movieService.addMovie(m), HttpStatus.OK);
    }
    @PostMapping("/POST/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director d){
//        return movieService.addDirectro(d);
        return new ResponseEntity<>(movieService.addDirectro(d), HttpStatus.OK);
    }
    @PostMapping("/POST/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("mname") String movieName, @RequestParam("dname") String dirName){
//        return movieService.addMovieDirectorPair(movieName, dirName);
        return new ResponseEntity<>(movieService.addMovieDirectorPair(movieName, dirName), HttpStatus.OK);
    }
    @GetMapping("/GET/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String movieName){
//        return movieService.getMovieByName(movieName);
        return new ResponseEntity<>(movieService.getMovieByName(movieName), HttpStatus.OK);
    }
    @GetMapping("/GET/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String dirName){
//        return movieService.getDirectorByName(dirName);
        return new ResponseEntity<>(movieService.getDirectorByName(dirName), HttpStatus.OK);
    }
    @GetMapping("/GET/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String dirName){
//        return movieService.getMoviesByDirectorName(dirName);
        return new ResponseEntity<>(movieService.getMoviesByDirectorName(dirName), HttpStatus.OK);
    }
    @GetMapping("/GET/movies/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
//        return movieService.findAllMovies();
        return new ResponseEntity<>(movieService.findAllMovies(), HttpStatus.OK);
    }
    @DeleteMapping("/DELETE/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("director") String dirName){
//        return movieService.deleteDirectorByName(dirName);
        return new ResponseEntity<>(movieService.deleteDirectorByName(dirName), HttpStatus.OK);
    }
    @DeleteMapping("/DELETE/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
//        return movieService.deleteAllDirectors();
        return new ResponseEntity<>(movieService.deleteAllDirectors(), HttpStatus.OK);
    }
}
