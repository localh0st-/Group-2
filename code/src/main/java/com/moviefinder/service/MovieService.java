package com.moviefinder.service;

import com.moviefinder.bean.Movie;
import com.moviefinder.bean.Showtime;
import com.moviefinder.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.*;

@Service
public class MovieService {

    private final MovieRepository repository;

    @Autowired
    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }


    public List<Movie> findByTitleContaining(String title) {
        return repository.findByTitleContaining(title);
    }

    public List<Movie> findAll() {
        return (List<Movie>) repository.findAll();
    }

    public Optional<Movie> findById(long id) {
        return repository.findById(id);
    }

    public Map<String, HashSet<Time>> findTheatersByMovieId(long id) {
        Movie m = repository.findMovieById(id).get(0);
        HashSet values;
        Map<String, HashSet<Time>> tl = new HashMap<>();
        for (Showtime s : m.getShowtimes()) {
            values = new HashSet();
            if (tl.get(s.getTheater().getName()) != null) {
                values = tl.get(s.getTheater().getName());
            }
            values.add(s.getStart_time());
            tl.put(s.getTheater().getName(), values);
        }
        return tl;
    }

    public List<Showtime> findShowtimesByMovieId(int id) {
        return repository.findMovieById(id).get(0).getShowtimes();
    }

}
