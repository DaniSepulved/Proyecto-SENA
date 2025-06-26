package com.example.parqueadero.controller;

import com.example.parqueadero.dto.ReservaDTO;
import com.example.parqueadero.model.Reservas;
import com.example.parqueadero.service.ReservaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    public ResponseEntity<Reservas> crearReserva(@RequestBody ReservaDTO dto) {
        return ResponseEntity.ok(reservaService.crearReserva(dto));
    }

    @GetMapping
    public ResponseEntity<List<Reservas>> listarReservas() {
        return ResponseEntity.ok(reservaService.listarReservas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservas> obtenerReserva(@PathVariable Long id) {
        return ResponseEntity.ok(reservaService.obtenerReservaPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReserva(@PathVariable Long id) {
        reservaService.eliminarReserva(id);
        return ResponseEntity.noContent().build();
    }
}