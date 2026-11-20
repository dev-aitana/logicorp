package com.core.logicorp.model;

import com.core.logicorp.model.enums.EstadoPaquete;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "historial_estados")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HistorialEstados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paquete_id", nullable = false)
    private Paquete paqueteId;

    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private EstadoPaquete estado;

    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empleado_responsable_id")
    private Empleado empleadoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "oficina_id")
    private Oficina oficinaId;

    @PrePersist
    protected void onCreate() {
        if (this.fechaHora == null)
            this.fechaHora = LocalDateTime.now();
    }
}
