package com.movieFlix.service;

import com.movieFlix.entity.Category;
import com.movieFlix.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category save(Category category){
        return repository.save(category);
    }

    public Optional<Category> findById(Long id){
        return repository.findById(id);
    }
}
