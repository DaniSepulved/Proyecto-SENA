package com.example.parqueadero.service.impl;

import com.example.parqueadero.dto.EspaciosParqueoDTO;
import com.example.parqueadero.model.EspaciosParqueo;
import com.example.parqueadero.repository.EspaciosParqueoRepository;
import com.example.parqueadero.service.EspaciosParqueoService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EspaciosParqueoServiceImpl implements EspaciosParqueoService {

    private final EspaciosParqueoRepository repository;

    @Override
    public EspaciosParqueoDTO crearEspacio(EspaciosParqueoDTO dto) {
        if (repository.existsByNumeroEspacio(dto.getNumeroEspacio())) {
            throw new RuntimeException("El número de espacio ya existe");
        }
        EspaciosParqueo espacio = mapToEntity(dto);
        return mapToDTO(repository.save(espacio));
    }

    @Override
    public EspaciosParqueoDTO actualizarEspacio(Integer id, EspaciosParqueoDTO dto) {
        EspaciosParqueo espacio = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Espacio no encontrado"));

        espacio.setUbicacion(dto.getUbicacion());
        espacio.setNumeroEspacio(dto.getNumeroEspacio());

        return mapToDTO(repository.save(espacio));
    }

    @Override
    public void eliminarEspacio(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public EspaciosParqueoDTO obtenerEspacioPorId(Integer id) {
        EspaciosParqueo espacio = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Espacio no encontrado"));
        return mapToDTO(espacio);
    }

    @Override
    public List<EspaciosParqueoDTO> listarEspacios() {
        return repository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private EspaciosParqueo mapToEntity(EspaciosParqueoDTO dto) {
        return EspaciosParqueo.builder()
                .idEspacio(dto.getIdEspacio())
                .ubicacion(dto.getUbicacion())
                .numeroEspacio(dto.getNumeroEspacio())
                .build();
    }

    private EspaciosParqueoDTO mapToDTO(EspaciosParqueo espacio) {
        EspaciosParqueoDTO dto = new EspaciosParqueoDTO();
        dto.setIdEspacio(espacio.getIdEspacio());
        dto.setUbicacion(espacio.getUbicacion());
        dto.setNumeroEspacio(espacio.getNumeroEspacio());
        return dto;
    }
}
