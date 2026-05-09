package com.barriohub.backend.service;

import com.barriohub.backend.dto.auth.LoginRequest;
import com.barriohub.backend.dto.auth.LoginResponse;
import com.barriohub.backend.dto.auth.RegisterRequest;
import com.barriohub.backend.entity.Usuario;
import com.barriohub.backend.repository.UsuarioRepository;
import com.barriohub.backend.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public Usuario register(RegisterRequest request) {

        Usuario usuario = Usuario.builder()
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .telefono(request.getTelefono())
                .rol(request.getRol())
                .build();

        return usuarioRepository.save(usuario);
    }
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    public LoginResponse login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        String token = jwtService.generateToken(request.getEmail());

        return new LoginResponse(token);
    }
}