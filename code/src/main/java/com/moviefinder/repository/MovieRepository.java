package com.moviefinder.repository;

import com.moviefinder.bean.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByTitleContaining(@Param("title") String title);

    List<Movie> findMovieById(long id);
}
