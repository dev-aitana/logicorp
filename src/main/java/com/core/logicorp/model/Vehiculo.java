package com.core.logicorp.model;
import com.core.logicorp.model.enums.EstadoVehiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "vehiculos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "matricula", nullable = false, unique = true, length = 20)
    private String matricula;

    @Column(name = "modelo", nullable = false, length = 100)
    private String modelo;

    @Column(name = "capacidad_kg", nullable = false, precision = 6, scale = 2)
    private BigDecimal capacidadKg;

    @Column(name = "estado", nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    private EstadoVehiculo estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "oficina_id", nullable = false)
    private Oficina oficina;

}
