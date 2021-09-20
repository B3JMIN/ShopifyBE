package com.example.image_repo.entities;

import lombok.*;

import javax.persistence.*;
//import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "image")
public class Image {
    public static final String IMAGE_NOT_PRESENT_EXCEPTION_MESSAGE = "This image is not currently present in the User's repo";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "imageName")
    private final String ImageName;
    @Column(name = "imageDate")
    private final String ImageDate;
    @ManyToOne
    private final User user;
    @Column(name = "imageLink")
    private final String ImageLink;

    @Column(name = "title")
    private final String title;

    @Column(name = "price")
    private float price;

    @Column(name = "permission")
    private Boolean isPublic;

    public Image(String imageName, String imageDate, User user, String imageLink, String title, Boolean isPublic) {
        this.ImageName = imageName;
        this.ImageDate = imageDate;
        this.user = user;
        this.ImageLink = imageLink;
        this.title = title;
        this.isPublic = isPublic;
    }
}
