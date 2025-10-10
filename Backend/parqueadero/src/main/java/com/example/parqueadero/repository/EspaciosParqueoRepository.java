package com.example.parqueadero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.parqueadero.model.EspaciosParqueo;

public interface EspaciosParqueoRepository extends JpaRepository<EspaciosParqueo, Integer> {
    boolean existsByNumeroEspacio(Integer numeroEspacio);
}
