package com.example.parqueadero.service;

import com.example.parqueadero.model.Usuarios;

import java.util.List;

import com.example.parqueadero.dto.UsuarioDTO;

public interface UsuarioService {
    Usuarios crear(UsuarioDTO dto);
    List<Usuarios> listar();
    Usuarios buscarPorId(Long id);
    Usuarios actualizar(Long id, UsuarioDTO dto);
    void eliminar(Long id);
}