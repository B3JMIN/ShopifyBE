package com.example.image_repo.service.impl;

import com.example.image_repo.entities.Image;
import com.example.image_repo.entities.User;
import com.example.image_repo.repository.JpaImageRepository;
import com.example.image_repo.repository.JpaUserRepository;
import com.example.image_repo.service.UserService;
import org.springframework.stereotype.Service;
import lombok.*;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {


    private JpaUserRepository userRepository;
    private JpaImageRepository imageRepository;

    @Override
    public void changeUserAdmin(UUID userId) {
        User user = userRepository.findById(userId).orElse(null);
        user.changeAdmin();
    }

    @Override
    public Optional<Image> sellImage(UUID userId) {
        Optional<Image> deletedImage = imageRepository.findById(userId);
        imageRepository.deleteById(userId);
        return deletedImage;
    }

    @Override
    public void setPrice(UUID userId, float price) {
        Image image = imageRepository.findById(userId).orElse(null);
        image.setPrice(price);
    }
}
