package com.movieFlix.controller;

import com.movieFlix.entity.Category;
import com.movieFlix.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "V1/movieflix/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> result = categoryService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Category> create(@RequestBody Category category){
        Category cat = categoryService.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(cat);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Category>> findById(@PathVariable Long id){
        Optional<Category> result = categoryService.findById(id);
        if (result.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
