package com.movieFlix.controller;

import com.movieFlix.controller.request.StreamingRequest;
import com.movieFlix.controller.response.StreamingResponse;
import com.movieFlix.entity.Streaming;
import com.movieFlix.mapper.StreamingMapper;
import com.movieFlix.service.StreamingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "V1/movieflix/streaming")
public class StreamingController {

    public final StreamingService streamingService;

    public StreamingController(StreamingService streamingService) {
        this.streamingService = streamingService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<StreamingResponse> create (@RequestBody StreamingRequest request){

        Streaming streaming = streamingService.save(StreamingMapper.toStreaming(request));

        return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.toStreamingResponse(streaming));
    }

    @GetMapping
    public ResponseEntity<List<StreamingResponse>> findAll(){
        return ResponseEntity.ok().body(streamingService.findAll().
                stream()
                .map(StreamingMapper::toStreamingResponse)
                .toList());
    }

    @GetMapping(value ="{id}")
    public ResponseEntity<StreamingResponse> findById(@PathVariable Long id){
        return streamingService.findById(id).map(streaming -> ResponseEntity.ok(StreamingMapper.toStreamingResponse(streaming))).
                orElseThrow();
    }
}
