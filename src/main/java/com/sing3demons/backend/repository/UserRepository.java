package com.sing3demons.backend.repository;

import com.sing3demons.backend.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,String> {
    Optional<User> findByEmail(String emain);
    boolean existsByEmail(String email);
}
