package com.barriohub.backend.entity;

import com.barriohub.backend.enums.Rol;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    private String telefono;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    private Boolean activo = true;

    private LocalDateTime fechaCreacion = LocalDateTime.now();


    @OneToMany(
            mappedBy = "usuario",
            fetch = FetchType.LAZY
    )
    @Builder.Default
    private List<MiembroBarrio> miembros = new ArrayList<>();
}
