package com.example.parqueadero.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Vehiculos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehiculos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_vehiculo;

    @Column(nullable = false, unique = true)
    private String placa;

    @Column(nullable = false)
    private String Color;

    @Column(nullable = false)
    private String Marca;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Rol Tipo_vehiculo;

    @ManyToOne
    @JoinColumn(name = "Id_usuario", nullable = false)
    private Usuarios usuario; 

    public boolean isEmpty() {
        return this.placa == null || this.placa.isEmpty() ||
               this.Color == null || this.Color.isEmpty() ||
               this.Marca == null || this.Marca.isEmpty() ||
               this.Tipo_vehiculo == null;
    }
}
