package com.quiroga.backend.model.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Article {
    private UUID id;
    private String title;
    private String slug;
    private String summary;
    private String content;
    private LocalDateTime publishedAt;

    public Article() {
    }

    public Article(UUID id, String title, String slug, String summary, String content, LocalDateTime publishedAt) {
        this.id = id;
        this.title = title;
        this.slug = slug;
        this.summary = summary;
        this.content = content;
        this.publishedAt = publishedAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDateTime publishedAt) {
        this.publishedAt = publishedAt;
    }
}
