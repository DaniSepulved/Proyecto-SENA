package com.example.parqueadero.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_usuario;

    @Column(nullable = false)
    private String Nombre;

    @Column(nullable = false)
    private String Apellido;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Rol Rol;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Vehiculos> vehiculos;

    public boolean isEmpty() {
        return this.Nombre == null || this.Nombre.isEmpty() ||
               this.Apellido == null || this.Apellido.isEmpty() ||
               this.email == null || this.email.isEmpty() ||
               this.password == null || this.password.isEmpty() ||
               this.Rol == null;
    }

    public Usuarios(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
}