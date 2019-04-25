package com.moviefinder.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Movies")
@Table(name = "movies")
@SecondaryTable(name = "metadata")
@Data
@EqualsAndHashCode(exclude = "showtimes")
public class Movie {

    @Id
    private long id;
    private String title;
    private String genre;
    private int year;
    private String rating;
    @Column(name = "trailer", table = "metadata", nullable = false)
    private String trailerUrl;
    @Column(name = "image", table = "metadata", nullable = false)
    private String imageUrl;
    @JsonManagedReference
    @OneToMany(mappedBy = "movie")
    private List<Showtime> showtimes = new ArrayList<>();

    public Movie() {
    }
}
