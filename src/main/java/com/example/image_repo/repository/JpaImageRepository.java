package com.example.image_repo.repository;

import com.example.image_repo.models.Image;
import com.example.image_repo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface JpaImageRepository extends JpaRepository<Image, UUID> {
    Optional<Image> findByUser(User user);
}
