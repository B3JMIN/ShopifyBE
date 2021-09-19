package com.example.image_repo.controller;


import com.example.image_repo.entities.Image;
import com.example.image_repo.repository.JpaImageRepository;
import com.example.image_repo.repository.JpaUserRepository;
import com.example.image_repo.service.ImageService;
import com.example.image_repo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

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


    @GetMapping(params = "showRepo")
    public ArrayList<Image> getImageInRepo(@RequestParam(required = false, defaultValue = "false") final Boolean showAdminRepoOnly){
        if (showAdminRepoOnly) return
    }
}
