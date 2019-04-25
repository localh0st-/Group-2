package com.moviefinder.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "showtimes")
@Data
public class Showtime {
    @Id
    private int id;
    private int theater_id;
    private int movie_id;
    private Time start_time;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "theater_id", insertable = false, updatable = false, nullable = false)
    private Theater theater;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "movie_id", insertable = false, updatable = false, nullable = false)
    private Movie movie;

    public Showtime() {
    }
}
