package com.example.parqueadero.service;

import com.example.parqueadero.dto.VehiculosDTO;
import com.example.parqueadero.model.Vehiculos;

import java.util.List;

public interface VehiculosService {
    Vehiculos crear(VehiculosDTO dto);
    Vehiculos actualizar(Long id, VehiculosDTO dto);
    void eliminar(Long id);
    List<Vehiculos> listar();
    Vehiculos buscarPorId(Long id);
}

