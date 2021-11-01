package com.example.image_repo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {

    public static final String IMAGE_NOT_PRESENT_EXCEPTION_MESSAGE = "This image is not currently present in the User's repo";
    public static final String IMAGE_ALREADY_PRESENT_EXCEPTION_MESSAGE = "This image is currently already present in the User's repo";
    @Id
    @GeneratedValue()
    private long id;

    public User(List<Image> imageRepo) {
        this.imageRepo = imageRepo;
    }

    @Column(name = "admin")
    private Boolean isAdmin;
    @OneToMany
    @JoinColumn
    private List<Image> imageRepo;


    public void addImage(final Image image){
        if (imageRepo.contains(image)) throw new IllegalArgumentException(IMAGE_ALREADY_PRESENT_EXCEPTION_MESSAGE);
        this.imageRepo.add(image);
    }

    public void removeImage(final Image image){
        if (!this.imageRepo.contains(image))
            throw new IllegalArgumentException(IMAGE_NOT_PRESENT_EXCEPTION_MESSAGE);
        this.imageRepo.remove(image);
    }

    public List<Image> getImageRepo(){
        return this.imageRepo;
    }
}
