package com.example.parqueadero.service;

import com.example.parqueadero.model.Usuarios;


public interface AuthService {
    Usuarios login(Usuarios usuarios);
    Usuarios authenticateUser(String email, String password);
}
