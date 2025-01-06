package com.movieFlix.controller.request;

import com.movieFlix.entity.Category;

import java.time.LocalDate;
import java.util.List;

public record MovieRequest(String tittle,
                           String description,
                           LocalDate releaseDate,
                           Double rating,
                           List<Long> categories,
                           List<Long> streaming) {
}
