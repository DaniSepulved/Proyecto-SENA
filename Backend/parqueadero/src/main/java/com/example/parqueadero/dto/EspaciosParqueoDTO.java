package com.example.parqueadero.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EspaciosParqueoDTO {
    private Long idEspacio;

    @NotBlank
    private String ubicacion;

    @NotNull
    private Integer numeroEspacio;
}
