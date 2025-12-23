package com.quiroga.backend.model.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SuccessStoryDTO {
    UUID id;
    String title;
    String clientName;
    String caseType;
    String story;

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate date;

    public SuccessStoryDTO() {
    }

    public SuccessStoryDTO(UUID id, String title, String clientName, String caseType, String story, LocalDate date) {
        this.id = id;
        this.title = title;
        this.clientName = clientName;
        this.caseType = caseType;
        this.story = story;
        this.date = date;
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

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
