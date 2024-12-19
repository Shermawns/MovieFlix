package com.movieFlix.service;

import com.movieFlix.entity.Streaming;
import com.movieFlix.repository.StreamingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StreamingService {

    private final StreamingRepository repository;

    public StreamingService(StreamingRepository repository) {
        this.repository = repository;
    }

    public List<Streaming> findAll(){
        return repository.findAll();
    }

    public Optional<Streaming> findById(Long id){
        return repository.findById(id);
    }

    public Streaming save (Streaming streaming){
        return repository.save(streaming);
    }
}
