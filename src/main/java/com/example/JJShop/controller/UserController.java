package com.example.JJShop.controller;

import com.example.JJShop.model.User;
import com.example.JJShop.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")

public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid User user){

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.createUser(user));
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable @Positive Long id){

        return ResponseEntity
                .ok()
                .body(userService.getUserById(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody @Valid User user, @PathVariable @Positive Long id){
        return ResponseEntity
                .ok()
                .body(userService.updateUser(user, id));
    }

    @GetMapping
    public ResponseEntity<List<User>> allUsers(){
        return ResponseEntity
                .ok()
                .body(userService.findAllUsers());
    }
}
