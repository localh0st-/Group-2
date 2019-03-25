package com.moviefinder.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "theaters")
@Data
public class Theater {
    @Id
    private int id;
    private String name;

    @JsonBackReference
    @OneToOne(mappedBy = "theater")
    private Showtime showtime;
}
