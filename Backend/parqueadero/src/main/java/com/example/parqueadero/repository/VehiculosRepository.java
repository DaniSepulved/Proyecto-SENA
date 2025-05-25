package com.example.parqueadero.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.parqueadero.model.Vehiculos;

public interface VehiculosRepository extends JpaRepository<Vehiculos, Long>{
    Optional<Vehiculos> findByPlaca(String placa); 
}