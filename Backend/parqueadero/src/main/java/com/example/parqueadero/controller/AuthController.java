package com.example.parqueadero.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.parqueadero.dto.UsuarioLoginDTO;
import com.example.parqueadero.exception.AuthenticationException;
import com.example.parqueadero.model.Usuarios;
import com.example.parqueadero.security.JwtUtil;
import com.example.parqueadero.service.AuthService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Authentication", description = "Authentication endpoints")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody UsuarioLoginDTO loginUser) {
        try {
            Usuarios usuario = new Usuarios(loginUser.getEmail(), loginUser.getPassword());
            Usuarios usuarioAutenticado = authService.login(usuario);

            String token = jwtUtil.generateToken(usuarioAutenticado);
            return ResponseEntity.ok(Map.of("token", token));
        } catch (AuthenticationException ex) {
            return ResponseEntity.status(401).body(Map.of("message", ex.getMessage()));
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(500).body(Map.of("message", "Error interno del servidor"));
        }
    }
}