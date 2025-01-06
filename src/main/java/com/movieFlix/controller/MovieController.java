package com.movieFlix.controller;

import com.movieFlix.controller.request.MovieRequest;
import com.movieFlix.controller.response.MovieResponse;
import com.movieFlix.entity.Movie;
import com.movieFlix.mapper.MovieMapper;
import com.movieFlix.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "V1/movieflix/movie")
public class MovieController {

    public final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<MovieResponse> create(@RequestBody MovieRequest movieRequest){

        Movie movie = movieService.save(MovieMapper.toMovie(movieRequest));

        return ResponseEntity.status(HttpStatus.CREATED).body(MovieMapper.toMovieResponse(movie));
    }

    @GetMapping
    public ResponseEntity<List<MovieResponse>> findAll(){
        return ResponseEntity.ok(movieService.findAll()
                .stream()
                .map(MovieMapper::toMovieResponse)
                .toList());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MovieResponse> findById(@PathVariable Long id){
        return movieService.findById(id)
                .map(movie -> ResponseEntity.ok(MovieMapper.toMovieResponse(movie)))
                .orElseThrow();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Long id){
        Optional<Movie> exist = movieService.findById(id);
        if (exist.isPresent()){
            movieService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
