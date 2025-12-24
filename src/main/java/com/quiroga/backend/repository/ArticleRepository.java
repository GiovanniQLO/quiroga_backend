package com.quiroga.backend.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import com.quiroga.backend.model.entity.Article;

import java.time.LocalDateTime;
import java.util.*;

@Repository
public class ArticleRepository {

    private final Map<UUID, Article> articles = new HashMap<>();

    @PostConstruct
    public void init() {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        UUID id3 = UUID.randomUUID();

        articles.put(id1, new Article(
                id1,
                "How Will Trump's Mass Deportation Plan Impact U.S. Agriculture?",
                "trump-deportation-plan-agriculture",
                "Former President Donald Trump's proposed mass deportation plan threatens to cripple U.S. agriculture by eliminating up to half of its workforce, according to analysts.",
                "Former President Donald Trump's proposed mass deportation plan threatens to cripple U.S. agriculture by eliminating up to half of its workforce, according to analysts. The potential economic impact could be severe, affecting food production and prices across the nation.",
                LocalDateTime.of(2025, 8, 2, 0, 0, 0)));

        articles.put(id2, new Article(
                id2,
                "What will Kamala Harris do about the border crisis?",
                "kamala-harris-border-crisis",
                "Immigration policy has been crucial in the 2024 presidential campaign, especially with Kamala Harris as the Democratic candidate. At our firm, we offer our perspective on Harris' impact on immigration policy and our challenges.",
                "Immigration policy has been crucial in the 2024 presidential campaign, especially with Kamala Harris as the Democratic candidate. At our firm, we offer our perspective on Harris' impact on immigration policy and our challenges. As the potential future president, her policies could significantly impact immigration law and enforcement.",
                LocalDateTime.of(2025, 7, 29, 0, 0, 0)));

        articles.put(id3, new Article(
                id3,
                "Immigration Medical Exam: Key for Green Card",
                "immigration-medical-exam-green-card",
                "To obtain permanent residency in the U.S., it is essential to pass a medical exam conducted by a USCIS-authorized physician. This exam, valid for six months, includes an evaluation of your medical history, a comprehensive physical examination, and the presentation of an updated vaccination record.",
                "To obtain permanent residency in the U.S., it is essential to pass a medical exam conducted by a USCIS-authorized physician. This exam, valid for six months, includes an evaluation of your medical history, a comprehensive physical examination, and the presentation of an updated vaccination record. Understanding the requirements and preparation for this exam is crucial for a successful application.",
                LocalDateTime.of(2025, 7, 25, 0, 0, 0)));
    }

    public List<Article> findAll() {
        return new ArrayList<>(articles.values());
    }

    public Optional<Article> findById(UUID id) {
        return Optional.ofNullable(articles.get(id));
    }

    public Optional<Article> findBySlug(String slug) {
        return articles.values().stream().filter(article -> article.getSlug().equals(slug)).findFirst();
    }

    public Article save (Article article){
        if(article.getId() == null){
            article.setId(UUID.randomUUID());
        }
        articles.put(article.getId(),article);
        return article;
    }
}
