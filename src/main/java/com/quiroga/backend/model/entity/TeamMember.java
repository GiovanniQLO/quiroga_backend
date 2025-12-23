package com.quiroga.backend.model.entity;

import java.util.UUID;

public class TeamMember {
    UUID id;
    String name;
    String role;
    String bio;
    String photoUrl;

    public TeamMember() {
    }

    public TeamMember(UUID id, String name, String role, String bio, String photoUrl) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.bio = bio;
        this.photoUrl = photoUrl;
    }
    

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

}