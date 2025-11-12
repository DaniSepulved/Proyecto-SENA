package com.example.parqueadero.service;

import com.example.parqueadero.dto.ReservaDTO;
import com.example.parqueadero.model.Reservas;

import java.util.List;

public interface ReservaService {
    Reservas crearReserva(ReservaDTO dto);
    List<Reservas> listarReservas();
    Reservas obtenerReservaPorId(Long id);
    void eliminarReserva(Long id);
}