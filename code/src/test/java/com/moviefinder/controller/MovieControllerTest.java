package com.moviefinder.controller;

import com.moviefinder.bean.Movie;
import com.moviefinder.service.MovieService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MovieController.class)
public class MovieControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private MovieService service;

    @Test
    public void givenMovies_whenGetMovies_thenReturnJsonArray() throws Exception {
        Movie m = new Movie();
        m.setId(1);
        m.setTitle("foo");
        m.setGenre("bar");
        m.setRating("lel");

        List<Movie> allMovies = Arrays.asList(m);

        given(service.findAll()).willReturn(allMovies);

        mvc.perform(get("/api/movies")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].title").value(m.getTitle()))
                .andExpect(jsonPath("$[0].id").value(m.getId()))
                .andExpect(jsonPath("$[0].genre").value(m.getGenre()));
    }

    @Test
    public void givenId_whenGetMovieById_thenReturnJson() throws Exception {
        Movie m = new Movie();
        m.setId(1);
        m.setTitle("foo");

        Optional<Movie> mov = Optional.of(m);

        given(service.findById(m.getId())).willReturn(mov);

        mvc.perform(get("/api/search")
                .contentType(MediaType.APPLICATION_JSON)
                .param("id", String.valueOf(m.getId())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(m.getId()))
                .andExpect(jsonPath("$.title").value(m.getTitle()));
    }

    @Test
    public void givenTitle_whenGetMoviesByTitle_thenReturnJsonArray() throws Exception {
        Movie m = new Movie();
        m.setId(2);
        m.setTitle("foo");
        m.setGenre("bar");
        m.setRating("lel");

        List<Movie> resultList = Arrays.asList(m);

        given(service.findByTitleContaining("fo")).willReturn(resultList);

        mvc.perform(get("/api/search")
                .contentType(MediaType.APPLICATION_JSON)
                .param("title", "fo"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].title").value(m.getTitle()))
                .andExpect(jsonPath("$[0].id").value(m.getId()));

    }
}
