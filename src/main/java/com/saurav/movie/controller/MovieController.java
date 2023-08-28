package com.saurav.movie.controller;

import com.saurav.movie.model.Movie;
import com.saurav.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/movies")
    public List<Movie> retriveAllMovies(){
        return movieRepository.findAll();
    }

    @GetMapping("/movies/{id}")
    public Movie getMovie(@PathVariable long id){
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if(optionalMovie.isEmpty()){
            return null;
        }else {
            return optionalMovie.get();
        }
    }

    @PostMapping("/movies")
    public Long createMovie(@RequestBody Movie movie){
        return movieRepository.save(movie).getId();
    }



}
