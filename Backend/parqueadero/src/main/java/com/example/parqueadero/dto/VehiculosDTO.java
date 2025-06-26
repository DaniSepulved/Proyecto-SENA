package com.example.parqueadero.dto;

import com.example.parqueadero.model.TipoVehiculo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VehiculosDTO {

    @NotBlank
    private String placa;

    @NotBlank
    private String color;

    @NotBlank
    private String marca;

    @NotNull
    private TipoVehiculo tipoVehiculo;

    @NotNull
    private Long idUsuario;
}