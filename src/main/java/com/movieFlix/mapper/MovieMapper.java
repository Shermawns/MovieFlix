package com.movieFlix.mapper;

import com.movieFlix.controller.request.MovieRequest;
import com.movieFlix.controller.response.CategoryResponse;
import com.movieFlix.controller.response.MovieResponse;
import com.movieFlix.controller.response.StreamingResponse;
import com.movieFlix.entity.Category;
import com.movieFlix.entity.Movie;
import com.movieFlix.entity.Streaming;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class MovieMapper {
    public Movie toMovie(MovieRequest movieRequest){

        List<Category> categories = movieRequest.categories().stream().
                map(categoryId -> Category.builder().id(categoryId).build()).toList();

        List<Streaming> streamings = movieRequest.streaming().stream().
                map(streamingId -> Streaming.builder().id(streamingId).build()).toList();


        return Movie.builder()
                .tittle(movieRequest.tittle())
                .description(movieRequest.description())
                .releaseDate(movieRequest.releaseDate())
                .rating(movieRequest.rating())
                .categories(categories)
                .streaming(streamings)
                .build();
    }


    public static MovieResponse toMovieResponse(Movie movie) {
        List<CategoryResponse> categories = movie.getCategories()
                .stream()
                .map(category -> CategoryResponse.builder()
                        .id(category.getId())
                        .name(category.getName())
                        .build())
                .toList();

        List<StreamingResponse> streaming = movie.getStreaming()
                .stream()
                .map(streamService -> StreamingResponse.builder()
                        .id(streamService.getId())
                        .name(streamService.getName())
                        .build())
                .toList();

        return MovieResponse.builder()
                .id(movie.getId())
                .tittle(movie.getTittle())
                .description(movie.getDescription())
                .rating(movie.getRating())
                .releaseDate(movie.getReleaseDate())
                .categories(categories)
                .streaming(streaming)
                .build();
    }

}
