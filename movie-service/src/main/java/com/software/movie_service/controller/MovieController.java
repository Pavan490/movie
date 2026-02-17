package com.software.movie_service.controller;

import com.software.movie_service.dto.MovieRequest;
import com.software.movie_service.entity.Movie;
import com.software.movie_service.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
@Slf4j
public class MovieController {
    private final MovieService movieService;
    @PostMapping("/create")
    public ResponseEntity<?> createMovie(@RequestBody MovieRequest movie) {
        Movie movie1=movieService.createMovie(movie);
        log.info("Movie Created Successfully");
        return ResponseEntity.ok().body(movie1);

    }
   @GetMapping("/get/{id}")
    public ResponseEntity<?> getMovie(@PathVariable Long id) {
        Movie movie=movieService.getMovie(id);
        log.info("Movie fetching Successfully");
        return ResponseEntity.ok().body(movie);

    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllMovies() {
        List<Movie> movie1=movieService.getMovies();
        log.info("Movies Fetching All Successfully");
        return ResponseEntity.ok().body(movie1);

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMovie(@PathVariable Long id ,@RequestBody MovieRequest movieRequest) {
        Movie movie= movieService.updateMovie(id,movieRequest);
        log.info("Movie Updated Successfully");
        return ResponseEntity.ok().body(movie);

    }
    @DeleteMapping
    public ResponseEntity<?> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        log.info("Movie Deleted Successfully");
        return ResponseEntity.ok().body("Movie Deleted Successfully");

    }
}
