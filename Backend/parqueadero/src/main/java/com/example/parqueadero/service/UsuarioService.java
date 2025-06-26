package com.example.parqueadero.service;

import com.example.parqueadero.model.Usuarios;
import com.example.parqueadero.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioService {
    Usuarios crear(UsuarioDTO dto);
    List<Usuarios> listar();
    Usuarios buscarPorId(Long id);
    Usuarios actualizar(Long id, UsuarioDTO dto);
    void eliminar(Long id);
}
