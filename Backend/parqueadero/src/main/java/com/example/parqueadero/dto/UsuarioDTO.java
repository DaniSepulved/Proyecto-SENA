package com.example.parqueadero.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import com.example.parqueadero.model.Rol;

@Data
public class UsuarioDTO {

    @NotBlank
    private String Nombre;

    @NotBlank
    private String Apellido;

    @Email
    private String email;

    @NotBlank
    private String Password;

    private Rol Rol;
}