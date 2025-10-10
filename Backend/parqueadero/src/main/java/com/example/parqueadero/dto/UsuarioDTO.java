package com.example.parqueadero.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import com.example.parqueadero.model.Rol;

@Data
public class UsuarioDTO {
    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    @Email
    private String email;

    @NotBlank
    private String password;

    @NotNull
    private Rol rol;
}