package com.example.parqueadero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.parqueadero.model.Reservas;

public interface ReservaRepository extends JpaRepository<Reservas, Long> {
}