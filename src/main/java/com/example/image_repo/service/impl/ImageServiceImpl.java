package com.example.image_repo.service.impl;

import com.example.image_repo.entities.Image;
import com.example.image_repo.repository.JpaImageRepository;
import com.example.image_repo.entities.User;
import com.example.image_repo.repository.JpaUserRepository;
import com.example.image_repo.service.ImageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public abstract class ImageServiceImpl implements ImageService {

    private JpaImageRepository imageRepository;
    private JpaUserRepository userRepository;
    @Override
    public Image addImage(Image image, User user) {
        imageRepository.save(image);
        return null;
    }

    @Override
    public Optional<Image> ViewImage(UUID ImageId){
        return imageRepository.findById(ImageId);
    }

    @Override
    public void deleteImageById(UUID imageId) {
//        add the user role in the future
        imageRepository.deleteById(imageId);
    }

    @Override
    public Optional<Image> findImageById(UUID imageId) {
        return imageRepository.findById(imageId);
    }

    @Override
    public void changeImageVisibility(UUID imageId) {
        Image image = imageRepository.findById(imageId).orElse(null);
//        return null;
    }

    @Override
    public ArrayList<Image> getAllAccessedImage(){
        return imageRepository.findAll()
                .stream()
                .filter(Image::)
    }

    @Override
    public List<Image> getAllImage(){
        return imageRepository.findAll();
    }
//    @Override
//    public Image uploadImage(Image image) {
//        return jpaImageRepository.save(image);
//    }
//
//    @Override
//    public void deleteImageById(UUID imageId) {
////        Optional<Image> foundImage = jpaImageRepository.findById(imageId);
//        jpaImageRepository.deleteById(imageId);
//    }
//
//    @Override
//    public List<Image> deleteImageByUser(User user) {
//        return null;
//        if(jpaImageRepository.findByUser(user) == null){
//            return null;
//        }
//        else{
//            return jpaImageRepository.findByUser(user);
//        }
    }
//
//    @Override
//    public Optional<Image> findImageById(UUID imageId) {
//        return jpaImageRepository.findById(imageId);
//    }
//
//    @Override
//    public List<Image> findAllImages() {
//        return jpaImageRepository.findAll();
//    }
//
//}
