package com.moviefinder.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Movies")
@Table(name = "movies")
@Data
public class    Movie {

    @Id
    private long id;
    private String title;
    private String genre;
    private int year;
    private String rating;

    public Movie(){
    }

    public Movie(long id, String title, String genre, int year, String rating) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
    }
}
