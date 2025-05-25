package com.example.parqueadero.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.parqueadero.exception.AuthenticationException;
import com.example.parqueadero.model.Usuarios;
import com.example.parqueadero.repository.UsuarioRepository;
import com.example.parqueadero.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Usuarios login(Usuarios usuarios) {
        Optional<Usuarios> optionalUser = usuarioRepository.findByEmail(usuarios.getEmail());

        if (optionalUser.isPresent()) {
            Usuarios usuariosLogin = optionalUser.get();
            if (passwordEncoder.matches(usuarios.getPassword(), usuariosLogin.getPassword())) {
                return usuariosLogin;
            }
        }

        throw new AuthenticationException("Email o contraseña incorrectos");
    }

    @Override
    public Usuarios authenticateUser(String email, String password) {
        Optional<Usuarios> optionalUser = usuarioRepository.findByEmail(email);
        return null;
    }
}