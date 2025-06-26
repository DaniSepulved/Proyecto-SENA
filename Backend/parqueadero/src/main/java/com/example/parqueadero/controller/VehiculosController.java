package com.example.parqueadero.controller;

import com.example.parqueadero.dto.VehiculosDTO;
import com.example.parqueadero.model.Vehiculos;
import com.example.parqueadero.service.VehiculosService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculosController {

    private final VehiculosService vehiculosService;

    public VehiculosController(VehiculosService vehiculosService) {
        this.vehiculosService = vehiculosService;
    }

    @PostMapping
    public ResponseEntity<Vehiculos> crear(@Valid @RequestBody VehiculosDTO dto) {
        return ResponseEntity.ok(vehiculosService.crear(dto));
    }

    @GetMapping
    public ResponseEntity<List<Vehiculos>> listar() {
        return ResponseEntity.ok(vehiculosService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehiculos> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(vehiculosService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehiculos> actualizar(@PathVariable Long id, @Valid @RequestBody VehiculosDTO dto) {
        return ResponseEntity.ok(vehiculosService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        vehiculosService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}