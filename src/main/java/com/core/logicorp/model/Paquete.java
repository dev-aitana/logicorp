package com.core.logicorp.model;

import com.core.logicorp.model.enums.EstadoPaquete;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "paquetes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Paquete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_tracking", nullable = false, unique = true, length = 50)
    private String codigoTracking;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "remitente_cliente_id")
    private Cliente remitenteId;

    @Column(name = "remitente_nombre", length = 150)
    private String remitenteNombre;

    @Column(name = "remitente_direccion")
    private String remitenteDireccion;

    @Column(name = "destinatario_nombre", nullable = false, length = 150)
    private String destinatarioNombre;

    @Column(name = "destinatario_direccion", nullable = false)
    private String destinatarioDireccion;

    @Column(name = "destinatario_cp", nullable = false, length = 10)
    private String destinatarioCp;

    @Column(name = "destinatario_telefono", length = 20)
    private String destinatarioTelefono;

    @Column(name = "peso_kg", nullable = false, precision = 6, scale = 2)
    private BigDecimal pesoKg;

    @Column(name = "fragil", nullable = false)
    private boolean fragil;

    @Column(name = "estado_actual", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private EstadoPaquete estadoActual;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_entrega_estimada")
    private LocalDateTime fechaEntregaEstimada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_paquete_id", nullable = false)
    private TiposPaquete tipoPaqueteId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "oficina_actual_id")
    private Oficina oficinaActualId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "repartidor_asignado_id")
    private Empleado repartidorAsignadoId;

    @PrePersist
    protected void onCreate() {
        this.fechaCreacion = LocalDateTime.now();
    }
}
