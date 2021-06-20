package com.sing3demons.backend.controller;

import com.sing3demons.backend.entity.User;
import com.sing3demons.backend.exception.BaseException;
import com.sing3demons.backend.mapper.UserMapper;
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
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody RegisterRequest userRequest) throws BaseException {
        User user = userService.create(userRequest);

        return new ResponseEntity<>(userMapper.toRegisterResponse(user), HttpStatus.CREATED);
    }

    @PostMapping("login")
    public ResponseEntity<String> login() throws BaseException {
        return ResponseEntity.ok("login");
    }
}
