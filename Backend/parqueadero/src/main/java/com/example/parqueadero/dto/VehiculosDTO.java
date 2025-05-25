package com.example.parqueadero.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class VehiculosDTO {
    
    @NotBlank
    private String Placa;

    @NotBlank
    private String Color;

    @NotBlank
    private String Marca;

    @NotBlank
    private String Tipo_vehiculo;
}
