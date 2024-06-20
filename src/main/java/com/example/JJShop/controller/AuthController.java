package com.example.JJShop.controller;

import com.example.JJShop.model.dto.AuthRequest;
import com.example.JJShop.model.dto.AuthResponse;
import com.example.JJShop.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService service;
    @PostMapping("login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody AuthRequest authRequest){
        return ResponseEntity.ok(service.login(authRequest));
    }
}
