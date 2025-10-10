package com.example.parqueadero.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReservaDTO {
    @NotNull
    private Long idUsuario;

    @NotNull
    private Long idTarifa;

    @NotNull
    private LocalDate fechaReserva;

    @NotNull
    private LocalDateTime horaInicio;

    @NotNull
    private LocalDateTime horaFin;
}
