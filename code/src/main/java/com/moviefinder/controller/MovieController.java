package com.moviefinder.controller;

import com.moviefinder.bean.Movie;
import com.moviefinder.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class MovieController extends BaseApiController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping("/movie/{id}")
    public Optional<Movie> movie(@PathVariable("id") long id) {
        return movieService.findById(id);
    }

    @RequestMapping("/movies")
    private List<Movie> movies(){
        return movieService.findall();
    }

    @RequestMapping("/search")
    private List<Movie> movies(@RequestParam(name = "title") String title) {
        List<Movie> movies = movieService.findByTitleContaining(title);
        return movies;
    }
}