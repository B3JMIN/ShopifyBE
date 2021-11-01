package com.example.image_repo.service;

import com.example.image_repo.models.Image;
import com.example.image_repo.models.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    Optional<User> viewUser(final UUID userId);
    User createUser();
    User createUser(final List<Image> imagesForUser);
    User addnewImageToUserRepo(final UUID userId, final Image ImageToAdd);
    User sellImageFromUserRepo(final UUID userId, final Image ImageToSell);
    void changeUserAdmin(UUID userId);
    void setPrice(UUID userId, float price);
}
