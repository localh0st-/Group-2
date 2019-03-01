package com.moviefinder.service;

import com.moviefinder.bean.Movie;
import com.moviefinder.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService{

    private final MovieRepository repository;

    @Autowired
    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public List<Movie> findByTitleContaining(String title) {
        return repository.findByTitleContaining(title);
    }

    public List<Movie> findall() {
        return (List<Movie>) repository.findAll();
    }

    public Optional<Movie> findById(long id) {
        return repository.findById(id);
    }
}
