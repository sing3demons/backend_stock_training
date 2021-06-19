package com.sing3demons.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    @GetMapping("")
    public ResponseEntity<Object> findAll(){
        Map<String,String> msg = new HashMap<String,String>();
        msg.put("message","Hello, World");
        return  ResponseEntity.ok(msg);
    }
}
