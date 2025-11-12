package com.example.parqueadero.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Long idUsuario;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Rol rol;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Vehiculos> vehiculos;

    public boolean isEmpty() {
        return this.nombre == null || this.nombre.isEmpty() ||
               this.apellido == null || this.apellido.isEmpty() ||
               this.email == null || this.email.isEmpty() ||
               this.password == null || this.password.isEmpty() ||
               this.rol == null;
    }

    public Usuarios(String email, String password) {
        this.email = email;
        this.password = password;
    }
}