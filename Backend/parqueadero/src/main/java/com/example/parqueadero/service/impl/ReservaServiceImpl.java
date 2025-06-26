package com.example.parqueadero.service.impl;

import com.example.parqueadero.dto.ReservaDTO;
import com.example.parqueadero.model.Reservas;
import com.example.parqueadero.model.Tarifas;
import com.example.parqueadero.model.Usuarios;
import com.example.parqueadero.repository.ReservaRepository;
import com.example.parqueadero.repository.TarifaRepository;
import com.example.parqueadero.repository.UsuarioRepository;
import com.example.parqueadero.service.ReservaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TarifaRepository tarifaRepository;

    @Override
    public Reservas crearReserva(ReservaDTO dto) {
        Usuarios usuario = usuarioRepository.findById(dto.getIdUsuario().longValue())
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Tarifas tarifa = tarifaRepository.findById(dto.getIdTarifa().longValue())
            .orElseThrow(() -> new RuntimeException("Tarifa no encontrada"));

        Reservas reserva = Reservas.builder()
            .usuarios(usuario)
            .tarifas(tarifa)
            .fechaReserva(dto.getFechaReserva())
            .horaInicio(dto.getHoraInicio())
            .horaFin(dto.getHoraFin())
            .build();

        Reservas reservaGuardada = reservaRepository.save(reserva);

        // Aquí podrías enviar la impresión
        System.out.println("🧾 Reserva creada: " + reservaGuardada);

        return reservaGuardada;
    }

    @Override
    public List<Reservas> listarReservas() {
        return reservaRepository.findAll();
    }

    @Override
    public Reservas obtenerReservaPorId(Long id) {
        return reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
    }

    @Override
    public void eliminarReserva(Long id) {
        reservaRepository.deleteById(id);
    }
}