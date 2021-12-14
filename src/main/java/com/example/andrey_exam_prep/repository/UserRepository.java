package com.example.andrey_exam_prep.repository;

import com.example.andrey_exam_prep.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findUserEntityByUsernameAndPassword(String username, String password);
}
