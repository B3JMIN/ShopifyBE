package com.example.image_repo.service;

import com.example.image_repo.models.Image;
import com.example.image_repo.models.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ImageService {
    Image addImage(Image image, User user);
    public Optional<Image> ViewImage(final UUID ImageId);
    Optional<Image> getImageById(final UUID ImageId);
    void changeImageVisibility(UUID imageId, Boolean visibility);
    void deleteImageById(UUID imageId);
    List<Image> getAllAccessedImage();
    List<Image> getAllImage();
    List<Image> getImagesByTitle(final String imageTitle);
}
