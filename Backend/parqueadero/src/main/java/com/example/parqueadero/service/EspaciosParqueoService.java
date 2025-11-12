package com.example.parqueadero.service;

import com.example.parqueadero.dto.EspaciosParqueoDTO;
import java.util.List;

public interface EspaciosParqueoService {
    EspaciosParqueoDTO crearEspacio(EspaciosParqueoDTO dto);
    EspaciosParqueoDTO actualizarEspacio(Integer id, EspaciosParqueoDTO dto);
    void eliminarEspacio(Integer id);
    EspaciosParqueoDTO obtenerEspacioPorId(Integer id);
    List<EspaciosParqueoDTO> listarEspacios();
}
