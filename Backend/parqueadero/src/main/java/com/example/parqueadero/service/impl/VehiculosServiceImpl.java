package com.example.parqueadero.service.impl;

import com.example.parqueadero.dto.VehiculosDTO;
import com.example.parqueadero.model.Usuarios;
import com.example.parqueadero.model.Vehiculos;
import com.example.parqueadero.repository.UsuarioRepository;
import com.example.parqueadero.repository.VehiculosRepository;
import com.example.parqueadero.service.VehiculosService;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculosServiceImpl implements VehiculosService {

    private final VehiculosRepository vehiculosRepository;
    private final UsuarioRepository usuarioRepository;

    public VehiculosServiceImpl(VehiculosRepository vehiculosRepository, UsuarioRepository usuarioRepository) {
        this.vehiculosRepository = vehiculosRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Vehiculos crear(VehiculosDTO dto) {
        Usuarios usuario = usuarioRepository.findById(dto.getIdUsuario())
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con ID: " + dto.getIdUsuario()));

        Vehiculos vehiculo = Vehiculos.builder()
                .placa(dto.getPlaca())
                .color(dto.getColor())
                .marca(dto.getMarca())
                .tipoVehiculo(dto.getTipoVehiculo())
                .usuario(usuario)
                .build();

        return vehiculosRepository.save(vehiculo);
    }

    @Override
    public Vehiculos actualizar(Long id, VehiculosDTO dto) {
        Vehiculos vehiculo = buscarPorId(id);

        vehiculo.setPlaca(dto.getPlaca());
        vehiculo.setColor(dto.getColor());
        vehiculo.setMarca(dto.getMarca());
        vehiculo.setTipoVehiculo(dto.getTipoVehiculo());

        if (dto.getIdUsuario() != null) {
            Usuarios usuario = usuarioRepository.findById(dto.getIdUsuario())
                    .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con ID: " + dto.getIdUsuario()));
            vehiculo.setUsuario(usuario);
        }

        return vehiculosRepository.save(vehiculo);
    }

    @Override
    public void eliminar(Long id) {
        vehiculosRepository.deleteById(id);
    }

    @Override
    public List<Vehiculos> listar() {
        return vehiculosRepository.findAll();
    }

    @Override
    public Vehiculos buscarPorId(Long id) {
        return vehiculosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vehículo no encontrado con ID: " + id));
    }
}