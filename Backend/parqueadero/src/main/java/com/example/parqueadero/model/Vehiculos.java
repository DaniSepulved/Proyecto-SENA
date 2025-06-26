package com.example.parqueadero.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehiculos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehiculos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehiculo;

    @Column(nullable = false, unique = true)
    private String placa;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String marca;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoVehiculo tipoVehiculo;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuarios usuario;

    public boolean isEmpty() {
        return this.placa == null || this.placa.isEmpty() ||
               this.color == null || this.color.isEmpty() ||
               this.marca == null || this.marca.isEmpty() ||
               this.tipoVehiculo == null;
    }
}