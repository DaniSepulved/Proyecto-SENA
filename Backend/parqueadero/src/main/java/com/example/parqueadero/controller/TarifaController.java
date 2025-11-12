package com.example.parqueadero.controller;

import com.example.parqueadero.dto.TarifaDTO;
import com.example.parqueadero.model.TipoVehiculo;
import com.example.parqueadero.service.TarifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tarifas")
public class TarifaController {

    @Autowired
    private TarifaService tarifaService;

    @GetMapping
    public List<TarifaDTO> getAll() {
        return tarifaService.obtenerTodas();
    }

    @PostMapping
    public TarifaDTO save(@RequestBody TarifaDTO dto) {
        return tarifaService.guardarTarifa(dto);
    }

    @GetMapping("/calcular")
    public Float calcular(
            @RequestParam TipoVehiculo tipoVehiculo,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fin
    ) {
        return tarifaService.calcularCosto(tipoVehiculo, inicio, fin);
    }
}