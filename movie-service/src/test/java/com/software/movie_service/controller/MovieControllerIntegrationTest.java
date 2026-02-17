package com.software.movie_service.controller;

import com.software.movie_service.entity.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;


import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MovieControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @Test
     void createMovie() throws Exception {
        Movie movie = new Movie();
            movie.setMovieName("rrr");
            movie.setMovieDescription("telugu pan india movie");
            movie.setDirector("raju");
            movie.setActors(List.of("ntr","ramcharan","team"));
         var res=   mockMvc.perform(post("/movie/create").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(movie)));

         res.andDo(print())
                 .andExpect(status().isOk())
                 .andExpect(jsonPath("$.movieId",is(notNullValue())))
                 .andExpect(jsonPath("$.movieName",is(movie.getMovieName())))
                 .andExpect(jsonPath("$.director",is(movie.getDirector())))
                 .andExpect(jsonPath("$.movieDescription",is(movie.getMovieDescription())))
                 .andExpect(jsonPath("$.actors",is(movie.getActors())));


     }

}