package com.moviefinder.bean;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "Movies")
@Table(name = "movies")
@SecondaryTable(name = "metadata")
@Data
public class Movie {

    @Id
    private long id;
    private String title;
    private String genre;
    private int year;
    private String rating;
    @Column(name = "trailer",table = "metadata",nullable = false)
    private String trailerUrl;
    @Column(name = "image", table = "metadata", nullable = false)
    private String imageUrl;

    public Movie() {
    }
}
