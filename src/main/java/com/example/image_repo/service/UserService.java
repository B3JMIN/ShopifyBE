package com.example.image_repo.service;

import com.example.image_repo.entities.Image;
import com.example.image_repo.entities.User;

import java.util.Optional;
import java.util.UUID;

public interface UserService {
    void changeUserAdmin(UUID userId);
    Optional<Image> sellImage(UUID userId);
    void setPrice(UUID userId, float price);
}
