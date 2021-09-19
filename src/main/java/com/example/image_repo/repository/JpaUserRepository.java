package com.example.image_repo.repository;

import com.example.image_repo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaUserRepository extends JpaRepository<User, UUID> {

}
