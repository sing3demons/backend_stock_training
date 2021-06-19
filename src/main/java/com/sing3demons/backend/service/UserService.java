package com.sing3demons.backend.service;

import com.sing3demons.backend.entity.User;
import com.sing3demons.backend.exception.BaseException;
import com.sing3demons.backend.exception.UserException;
import com.sing3demons.backend.models.RegisterRequest;
import com.sing3demons.backend.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User create(RegisterRequest user) throws BaseException {
        //validate
        if (Objects.isNull(user.getEmail())) {
            throw UserException.createEmailNull();
        }
        if (Objects.isNull(user.getPassword())) {
            throw UserException.createPasswordNull();
        }
        if (Objects.isNull(user.getName())) {
            throw UserException.createNameNull();
        }

        //verify
        if (userRepository.existsByEmail(user.getEmail())) {
            throw UserException.createEmailDuplicated();
        }

        User entity = new User();
        entity.setEmail(user.getEmail());
        entity.setPassworld(bCryptPasswordEncoder.encode(user.getPassword()));
        entity.setName(user.getName());
        return userRepository.save(entity);
    }
}
