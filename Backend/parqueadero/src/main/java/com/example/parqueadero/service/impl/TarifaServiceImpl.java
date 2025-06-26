package com.example.parqueadero.service.impl;

import com.example.parqueadero.dto.TarifaDTO;
import com.example.parqueadero.model.Tarifas;
import com.example.parqueadero.model.TipoVehiculo;
import com.example.parqueadero.repository.TarifaRepository;
import com.example.parqueadero.service.TarifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TarifaServiceImpl implements TarifaService {

    @Autowired
    private TarifaRepository tarifaRepository;

    @Override
    public List<TarifaDTO> obtenerTodas() {
        return tarifaRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TarifaDTO guardarTarifa(TarifaDTO dto) {
        Tarifas tarifa = Tarifas.builder()
                .tipoVehiculo(dto.getTipoVehiculo())
                .costoHora(dto.getCostoHora())
                .costoDia(dto.getCostoDia())
                .build();
        return toDTO(tarifaRepository.save(tarifa));
    }

    @Override
    public Float calcularCosto(TipoVehiculo tipoVehiculo, LocalDateTime inicio, LocalDateTime fin) {
        Tarifas tarifa = tarifaRepository.findByTipoVehiculo(tipoVehiculo)
                .orElseThrow(() -> new RuntimeException("Tarifa no encontrada para: " + tipoVehiculo));

        long horas = ChronoUnit.HOURS.between(inicio, fin);
        long dias = ChronoUnit.DAYS.between(inicio.toLocalDate(), fin.toLocalDate());

        if (horas >= 8 || dias >= 1) {
            return tarifa.getCostoDia() * (dias > 0 ? dias : 1);
        } else {
            return tarifa.getCostoHora() * (horas == 0 ? 1 : horas);
        }
    }

    private TarifaDTO toDTO(Tarifas tarifa) {
        return TarifaDTO.builder()
                .idTarifa(tarifa.getIdTarifa())
                .tipoVehiculo(tarifa.getTipoVehiculo())
                .costoHora(tarifa.getCostoHora())
                .costoDia(tarifa.getCostoDia())
                .build();
    }
}