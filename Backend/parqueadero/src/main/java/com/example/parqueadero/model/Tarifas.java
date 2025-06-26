package com.example.parqueadero.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tarifas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tarifas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTarifa")
    private Long idTarifa;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipoVehiculo", nullable = false)
    private TipoVehiculo tipoVehiculo;

    @Column(name = "costoHora")
    private Float costoHora;

    @Column(name = "costoDia")
    private Float costoDia;

    @OneToMany(mappedBy = "tarifas")
    private List<Reservas> reservas;
}
