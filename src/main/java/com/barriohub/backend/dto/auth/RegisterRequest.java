package com.barriohub.backend.dto.auth;

import com.barriohub.backend.enums.Rol;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

    private String nombre;

    private String apellido;

    private String email;

    private String password;

    private String telefono;

    private Rol rol;
}