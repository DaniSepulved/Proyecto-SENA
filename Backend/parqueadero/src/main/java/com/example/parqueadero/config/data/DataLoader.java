package com.example.parqueadero.config.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.parqueadero.model.Rol;
import com.example.parqueadero.model.Usuarios;
import com.example.parqueadero.repository.UsuarioRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public DataLoader(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if (usuarioRepository.findByEmail("admin@admin.com").isEmpty()) {
            Usuarios adminUser = Usuarios.builder()
                    .Nombre("Admin")
                    .Apellido("Principal")
                    .email("admin@admin.com")
                    .password(passwordEncoder.encode("admin123"))
                    .Rol(Rol.ADMIN)
                    .build();

            usuarioRepository.save(adminUser);
            System.out.println("✅ Usuario admin creado");
        } else {
            System.out.println("ℹ Usuario admin ya existe");
        }
    }
}