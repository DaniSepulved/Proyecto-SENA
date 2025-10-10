package com.example.parqueadero.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "espaciosparqueo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EspaciosParqueo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEspacio")
    private Long idEspacio;

    @Column(name = "ubicacion", nullable = false)
    private String ubicacion;

    @Column(name = "numeroEspacio", nullable = false, unique = true)
    private Integer numeroEspacio;
}