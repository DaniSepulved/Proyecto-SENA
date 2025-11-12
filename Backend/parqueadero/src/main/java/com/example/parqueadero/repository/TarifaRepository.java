package com.example.parqueadero.repository;

import com.example.parqueadero.model.Tarifas;
import com.example.parqueadero.model.TipoVehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TarifaRepository extends JpaRepository<Tarifas, Long> {
    Optional<Tarifas> findByTipoVehiculo(TipoVehiculo tipoVehiculo);
}