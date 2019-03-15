package com.moviefinder.repository;

import com.moviefinder.bean.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

    //    @Query("select m from Movies m where m.title like %:title%")
    List<Movie> findByTitleContaining(@Param("title") String title);

    @Query("select m from Movies m where m.id = :id")
    List<Movie> findShowtimesByMovieId(@Param("id") long id);

//    @Query("select t.name from theaters t where t.id = :id")
//    String findByTheaterId(@Param("id") long id);

    List<Movie> findMovieById(long id);
}
