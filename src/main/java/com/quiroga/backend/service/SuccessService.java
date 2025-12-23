package com.quiroga.backend.service;

import com.quiroga.backend.model.dto.SuccessStoryDTO;
import com.quiroga.backend.model.entity.SuccessStory;
import com.quiroga.backend.repository.SuccessRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SuccessService {
    
    private final SuccessRepository successRepository;
    
    public SuccessService(SuccessRepository successRepository) {
        this.successRepository = successRepository;
    }
    
    public List<SuccessStoryDTO> getAllSuccessStories() {
        return successRepository.findAll().stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }
    
    public Optional<SuccessStoryDTO> getSuccessStoryById(UUID id) {
        return successRepository.findById(id)
            .map(this::convertToDTO);
    }
    
    private SuccessStoryDTO convertToDTO(SuccessStory successStory) {
        return new SuccessStoryDTO(
            successStory.getId(),
            successStory.getTitle(),
            successStory.getClientName(),
            successStory.getCaseType(),
            successStory.getStory(),
            successStory.getDate()
        );
    }
}