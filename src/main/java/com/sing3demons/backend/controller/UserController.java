package com.sing3demons.backend.controller;

import com.sing3demons.backend.entity.User;
import com.sing3demons.backend.exception.BaseException;
import com.sing3demons.backend.models.RegisterRequest;
import com.sing3demons.backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody RegisterRequest userRequest) throws BaseException {
        User user = userService.create(userRequest);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
