package com.movieFlix.controller;

import com.movieFlix.controller.request.CategoryRequest;
import com.movieFlix.controller.response.CategoryResponse;
import com.movieFlix.entity.Category;
import com.movieFlix.mapper.CategoryMapper;
import com.movieFlix.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "V1/movieflix/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<CategoryResponse> create(@RequestBody CategoryRequest request){

        Category newCategory = CategoryMapper.toCategory(request);

        Category saveCategory = categoryService.save(newCategory);

        CategoryResponse response = CategoryMapper.toCategoryResponse(saveCategory);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> findAll(){
        return ResponseEntity.ok().
                body(categoryService.findAll().stream().
                        map(CategoryMapper::toCategoryResponse).
                        toList());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryResponse> findById(@PathVariable Long id){
        return categoryService.findById(id)
                .map(category -> ResponseEntity.ok(CategoryMapper.toCategoryResponse(category)))
                .orElseThrow();
    }
}
