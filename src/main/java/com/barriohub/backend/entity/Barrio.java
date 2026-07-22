package com.barriohub.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "barrios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Barrio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String direccion;

    private String ciudad;

    private String provincia;

    private String telefono;

    private String email;

    @Builder.Default
    private Boolean activo = true;

    @Builder.Default
    private LocalDateTime fechaAlta = LocalDateTime.now();

    @OneToMany(
            mappedBy = "barrio",
            fetch = FetchType.LAZY
    )
    @Builder.Default
    private List<MiembroBarrio> miembros = new ArrayList<>();
}