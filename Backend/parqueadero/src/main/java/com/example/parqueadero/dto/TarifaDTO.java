package com.example.parqueadero.dto;

import com.example.parqueadero.model.TipoVehiculo;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TarifaDTO {
    @NotBlank
    private Long idTarifa;

    @NotBlank
    private TipoVehiculo tipoVehiculo;

    @NotBlank
    private Float costoHora;

    @NotBlank
    private Float costoDia;
}