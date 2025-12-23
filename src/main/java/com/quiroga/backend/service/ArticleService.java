package com.quiroga.backend.service;

import com.quiroga.backend.model.dto.ArticleDTO;
import com.quiroga.backend.model.entity.Article;
import com.quiroga.backend.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ArticleService {
    
    private final ArticleRepository articleRepository;
    
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }
    
    public List<ArticleDTO> getAllArticles() {
        return articleRepository.findAll().stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }
    
    public Optional<ArticleDTO> getArticleById(UUID id) {
        return articleRepository.findById(id)
            .map(this::convertToDTO);
    }
    
    public Optional<ArticleDTO> getArticleBySlug(String slug) {
        return articleRepository.findBySlug(slug)
            .map(this::convertToDTO);
    }
    
    private ArticleDTO convertToDTO(Article article) {
        return new ArticleDTO(
            article.getId(),
            article.getTitle(),
            article.getSlug(),
            article.getSummary(),
            article.getContent(),
            article.getPublishedAt()
        );
    }
}