package com.example.parqueadero.controller;

import com.example.parqueadero.dto.EspaciosParqueoDTO;
import com.example.parqueadero.service.EspaciosParqueoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/espacios")
@RequiredArgsConstructor
public class EspaciosParqueoController {

    private final EspaciosParqueoService service;

    @PostMapping
    public ResponseEntity<EspaciosParqueoDTO> crear(@RequestBody EspaciosParqueoDTO dto) {
        return ResponseEntity.ok(service.crearEspacio(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EspaciosParqueoDTO> actualizar(@PathVariable Integer id,
                                                         @RequestBody EspaciosParqueoDTO dto) {
        return ResponseEntity.ok(service.actualizarEspacio(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminarEspacio(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EspaciosParqueoDTO> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.obtenerEspacioPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<EspaciosParqueoDTO>> listar() {
        return ResponseEntity.ok(service.listarEspacios());
    }
}
