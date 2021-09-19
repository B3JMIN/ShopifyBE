package com.example.image_repo.service;

import com.example.image_repo.entities.Image;
import com.example.image_repo.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ImageService {
    Image addImage(Image image, User user);
    public Optional<Image> ViewImage(final UUID ImageId);
    Optional<Image> findImageById(final UUID ImageId);
    void changeImageVisibility(UUID imageId);
    void deleteImageById(UUID imageId);
    List<Image> getAllAccessedImage();
    List<Image> getAllImage();
}
