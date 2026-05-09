package com.barriohub.backend.controller;

import com.barriohub.backend.dto.auth.RegisterRequest;
import com.barriohub.backend.entity.Usuario;
import com.barriohub.backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public Usuario register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }
}