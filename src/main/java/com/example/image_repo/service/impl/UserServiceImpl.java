package com.example.image_repo.service.impl;

import com.example.image_repo.models.Image;
import com.example.image_repo.models.User;
import com.example.image_repo.repository.JpaImageRepository;
import com.example.image_repo.repository.JpaUserRepository;
import com.example.image_repo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    public static final String USER_DOES_NOT_EXIST_ERROR_MESSAGE = "This user does not exist in the database.";

    private JpaUserRepository userRepository;
    private JpaImageRepository imageRepository;


    @Autowired
    public UserServiceImpl(final JpaUserRepository userRepository, final JpaImageRepository imageRepository){
        this.imageRepository = imageRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> viewUser(UUID userId) {
        return userRepository.findById(userId);
    }

    @Override
    public User createUser() {
        return createUser(Collections.emptyList());
    }

    @Override
    public User createUser(final List<Image> imagesForUser) {
        final User newUser = new User(Collections.emptyList());
        imagesForUser.forEach(newUser::addImage);

        return userRepository.save(newUser);
    }

    @Override
    public User addnewImageToUserRepo(UUID userId, Image ImageToAdd) {
        final User existingUser = getUserIfItExists(userId);
        existingUser.addImage(ImageToAdd);
        return userRepository.save(existingUser);
    }

    @Override
    public User sellImageFromUserRepo(UUID userId, Image ImageToSell) {
        final User existingUser = getUserIfItExists(userId);
        existingUser.removeImage(ImageToSell);
        return userRepository.save(existingUser);
    }

    @Override
    public void changeUserAdmin(UUID userId) {
        User user = userRepository.findById(userId).orElse(null);
    }

//    @Override
//    public Optional<Image> sellImage(UUID userId) {
//        Optional<Image> deletedImage = imageRepository.findById(userId);
//        imageRepository.deleteById(userId);
//        return deletedImage;
//    }

    @Override
    public void setPrice(UUID userId, float price) {
        Image image = imageRepository.findById(userId).orElse(null);
        image.setPrice(price);
    }

    private User getUserIfItExists(final UUID userId){
        final Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()) throw new IllegalArgumentException(USER_DOES_NOT_EXIST_ERROR_MESSAGE);

        return user.get();
    }
}
