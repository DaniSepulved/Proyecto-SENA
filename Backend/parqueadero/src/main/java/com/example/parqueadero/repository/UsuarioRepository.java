package com.example.parqueadero.repository;

import java.util.Optional;

// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.parqueadero.model.Usuarios;

public interface UsuarioRepository extends JpaRepository<Usuarios, Long>{
    Optional<Usuarios> findByEmail(String email);
}
