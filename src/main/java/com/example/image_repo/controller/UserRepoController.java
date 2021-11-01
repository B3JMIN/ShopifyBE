package com.example.image_repo.controller;


import com.example.image_repo.models.Image;
import com.example.image_repo.models.User;
import com.example.image_repo.service.ImageService;
import com.example.image_repo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class UserRepoController {
    public static final String USER_DOES_NOT_EXIST_ERROR_MESSAGE = "This user does not exist in the database.";

    private ImageService imageService;
    private UserService userService;
//    private JpaImageRepository imageRepository;
//    private JpaUserRepository userRepository;

    @Autowired
    public UserRepoController(final ImageService imageService, final UserService userService){
        this.imageService = imageService;
        this.userService = userService;
    }


    @GetMapping(params = "{userId}")
    public User viewUser(@PathVariable final UUID userId){
        Optional<User> user = userService.viewUser(userId);

        if (!user.isPresent()) throw new IllegalArgumentException(USER_DOES_NOT_EXIST_ERROR_MESSAGE);
        return user.get();
    }

    // todo: the below code has some issues
    @PostMapping
    public User createUser(@RequestBody(required = false) User user){
        if (Objects.isNull(user)) return new User(Collections.emptyList());
        List<Image> imagesInUserRepo = user.getImageRepo()
                .stream()
                .collect(Collectors.toList());
        return userService.createUser(imagesInUserRepo);
    }

    @PutMapping("{userId}/images/{imageId}")
    public User addImageToUserRepo(@PathVariable final UUID userId, @PathVariable final UUID imageId){
        final Optional<Image> imageToAdd = imageService.getImageById(imageId);
        if (!imageToAdd.isPresent()) throw new IllegalArgumentException(ImageRepoController.IMAGE_DOES_NOT_EXIST_ERROR_MESSAGE);
        if (!imageToAdd.get().getIsPublic()) throw new IllegalArgumentException(Image.IMAGE_NOT_PRESENT_EXCEPTION_MESSAGE);

        return userService.addnewImageToUserRepo(userId, imageToAdd.get());
    }

    @DeleteMapping("{UserId}/images/{imageId}")
    public User SellImageFromUserRepo(@PathVariable final UUID userId, @PathVariable final UUID imageId){
        final Optional<Image> imageToSell = imageService.getImageById(imageId);
        if (!imageToSell.isPresent()) throw new IllegalArgumentException(ImageRepoController.IMAGE_DOES_NOT_EXIST_ERROR_MESSAGE);
        if (!imageToSell.get().getIsPublic()) throw new IllegalArgumentException(Image.IMAGE_NOT_PRESENT_EXCEPTION_MESSAGE);

        return userService.sellImageFromUserRepo(userId, imageToSell.get());
    }
}
