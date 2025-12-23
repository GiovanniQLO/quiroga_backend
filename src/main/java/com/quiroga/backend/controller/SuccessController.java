package com.quiroga.backend.controller;

import com.quiroga.backend.model.dto.SuccessStoryDTO;
import com.quiroga.backend.service.SuccessService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/success")
@CrossOrigin(origins = "*")
public class SuccessController {
    
    private final SuccessService successService;
    
    public SuccessController(SuccessService successService) {
        this.successService = successService;
    }
    
    @GetMapping
    public ResponseEntity<List<SuccessStoryDTO>> getAllSuccessStories() {
        List<SuccessStoryDTO> successStories = successService.getAllSuccessStories();
        return ResponseEntity.ok(successStories);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<SuccessStoryDTO> getSuccessStoryById(@PathVariable UUID id) {
        return successService.getSuccessStoryById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}