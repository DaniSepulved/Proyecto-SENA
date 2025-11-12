package com.example.parqueadero.service;

import com.example.parqueadero.dto.TarifaDTO;
import com.example.parqueadero.model.TipoVehiculo;

import java.time.LocalDateTime;
import java.util.List;

public interface TarifaService {
    List<TarifaDTO> obtenerTodas();
    TarifaDTO guardarTarifa(TarifaDTO dto);
    Float calcularCosto(TipoVehiculo tipoVehiculo, LocalDateTime inicio, LocalDateTime fin);
}