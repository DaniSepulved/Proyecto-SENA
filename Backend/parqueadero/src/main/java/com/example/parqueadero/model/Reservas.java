package com.example.parqueadero.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

// import jakarta.persistence.Column;
import jakarta.persistence.Entity;
// import jakarta.persistence.EnumType;
// import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reservas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReserva;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuarios usuarios;

    // @ManyToOne
    // @JoinColumn(name = "idEspacio", nullable = false)
    // private EspacioParqueo espacioParqueo;

    @ManyToOne
    @JoinColumn(name = "idTarifa", nullable = false)
    private Tarifas tarifas;

    private LocalDate fechaReserva;

    private LocalDateTime horaInicio;
    private LocalDateTime horaFin;

    // @OneToOne(mappedBy = "reserva", cascade = CascadeType.ALL)
    // private Pago pago;
}
