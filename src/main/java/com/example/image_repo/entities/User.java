package com.example.image_repo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue()
    private long id;

    @Column(name = "username")
    private String userName;
    // password need to be hashed
    @Column(name = "password")
    private String password;
    @Column(name = "admin")
    private Boolean isAdmin;
    private ArrayList<String> imageRepo;

    public User(String userName, String password, ArrayList<String> imageRepo) {
        this.userName = userName;
        this.password = password;
        this.imageRepo = imageRepo;
        isAdmin = true;
    }

    public void changeAdmin() {
        if(isAdmin){
            isAdmin = false;
        }
        isAdmin = true;
    }
}
