package com.moviefinder.controller;

import com.moviefinder.bean.Movie;
import com.moviefinder.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.*;

@RestController
public class MovieController extends BaseApiController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping("/searchById")
    public Optional<Movie> movie(@RequestParam(name = "id") long id) {
        return movieService.findById(id);
    }

    @RequestMapping("/movies")
    private List<Movie> movies(){
        return movieService.findAll();
    }

    @RequestMapping("/search")
    private List<Movie> movies(@RequestParam(name = "title") String title) {
        return movieService.findByTitleContaining(title);
    }

    @RequestMapping("/theater")
    private Map<String, HashSet<Time>> theaters(@RequestParam(name = "movieid") long id) {
        return movieService.findTheatersByMovieId(id);
    }
}
