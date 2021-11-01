package com.example.image_repo.service.impl;

import com.example.image_repo.models.Image;
import com.example.image_repo.repository.JpaImageRepository;
import com.example.image_repo.models.User;
import com.example.image_repo.repository.JpaUserRepository;
import com.example.image_repo.service.ImageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public abstract class ImageServiceImpl implements ImageService {

    private JpaImageRepository imageRepository;
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
    public Optional<Image> getImageById(UUID imageId) {
        return imageRepository.findById(imageId);
    }

    @Override
    public void changeImageVisibility(UUID imageId, Boolean visibility) {
        Image image = imageRepository.findById(imageId).orElse(null);
        image.setIsPublic(visibility);
    }

    @Override
    public List<Image> getAllAccessedImage(){
        return imageRepository.findAll()
                .stream()
                .filter(Image::getIsPublic)
                .collect(Collectors.toList());
    }

    @Override
    public List<Image> getAllImage(){
        return imageRepository.findAll();
    }

    @Override
    public List<Image> getImagesByTitle(String imageTitle) {
        return imageRepository.findAll()
                .stream()
                .filter(image -> image.getTitle().equals(imageTitle))
                .collect(Collectors.toList());
    }
}
