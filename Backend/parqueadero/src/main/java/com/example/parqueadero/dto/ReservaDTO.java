package com.example.parqueadero.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ReservaDTO {
    @NotBlank
    private Long idUsuario;

    @NotBlank
    private Long idTarifa;

    @NotBlank
    private LocalDate fechaReserva;

    @NotBlank
    private LocalDateTime horaInicio;

    @NotBlank
    private LocalDateTime horaFin;
}
