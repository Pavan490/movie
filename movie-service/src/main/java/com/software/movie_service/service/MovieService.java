package com.software.movie_service.service;

import com.software.movie_service.dto.MovieRequest;
import com.software.movie_service.entity.Movie;
import com.software.movie_service.repository.MovieRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MovieService {
    private final MovieRepository movieRepository;
    private final ModelMapper modelMapper;

    public Movie createMovie(MovieRequest movieRequest){
        Movie movie=modelMapper.map(movieRequest,Movie.class);
        return movieRepository.save(movie);
    }

    public Movie getMovie(Long id){
        return movieRepository.findById(id).orElseThrow(()->new RuntimeException("Movie not found" +id));
    }

    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

    public Movie updateMovie(Long id,MovieRequest movieRequest){
        Movie movie =movieRepository.findById(id).orElseThrow(()->new RuntimeException("Movie not found" +id));
        modelMapper.map(movieRequest,movie);
        return movieRepository.save(movie);
    }
    public void deleteMovie(Long id){
        movieRepository.deleteById(id);
    }




}
