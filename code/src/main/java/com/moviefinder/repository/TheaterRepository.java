package com.moviefinder.repository;

import com.moviefinder.bean.Movie;
import com.moviefinder.bean.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long> {

}
