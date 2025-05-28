package com.example.parqueadero.service.impl;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.parqueadero.dto.UsuarioDTO;
import com.example.parqueadero.model.Rol;
import com.example.parqueadero.model.Usuarios;
import com.example.parqueadero.repository.UsuarioRepository;
import com.example.parqueadero.service.UsuarioService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    private final UsuarioRepository repo;
    private final PasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(UsuarioRepository repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Usuarios crear(UsuarioDTO dto) {
        Usuarios usuarios = Usuarios.builder()
                .Nombre(dto.getNombre())
                .Apellido(dto.getApellido())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .Rol(Rol.CLIENTE)
                .build();

        return repo.save(usuarios);
    }

    @Override
    public Usuarios actualizar(Long id, UsuarioDTO dto) {
        Usuarios usuarios = buscarPorId(id);

        usuarios.setNombre(dto.getNombre());
        usuarios.setApellido(dto.getApellido());
        usuarios.setEmail(dto.getEmail());

        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            usuarios.setPassword(passwordEncoder.encode(dto.getPassword()));
        }

        usuarios.setRol(dto.getRol());

        return repo.save(usuarios);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Usuarios> listar() {
    return repo.findAll();
    }

    @Override
    public Usuarios buscarPorId(Long id) {
    return repo.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con id " + id));
    }
}