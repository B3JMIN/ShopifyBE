package com.example.image_repo.entities;

import com.example.image_repo.entities.User;
import lombok.*;

import javax.persistence.*;
//import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "image")
public class Image {
    @Getter
    @Setter
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

    @Column(name = "tag")
    private final String Tag;

    @Column(name = "price")
    private float price;

    @Column(name = "permission")
    private Boolean isPublic;

    public Image(String imageName, String imageDate, User user, String imageLink, String Tag, Boolean isPublic) {
        this.ImageName = imageName;
        this.ImageDate = imageDate;
        this.user = user;
        this.ImageLink = imageLink;
        this.Tag = Tag;
        this.isPublic = isPublic;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    public void setPermission(Boolean isPublic){
        this.isPublic = isPublic;
    }
    
    public Boolean 
}
