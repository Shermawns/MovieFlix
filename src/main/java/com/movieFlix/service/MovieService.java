package com.movieFlix.service;

import com.movieFlix.entity.Movie;
import com.movieFlix.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    public final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie save(Movie movie){
        return movieRepository.save(movie);
    }

    public List<Movie> findAll(){
        return movieRepository.findAll();
    }

    public Optional<Movie> findById(Long id){
       return movieRepository.findById(id);
    }

    public void delete(Long id){
        movieRepository.deleteById(id);
    }
}
