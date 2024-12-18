package com.movieFlix.controller;

import com.movieFlix.entity.Category;
import com.movieFlix.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "V1/movieflix/category")
@RequiredArgsConstructor

public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> result = categoryService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
