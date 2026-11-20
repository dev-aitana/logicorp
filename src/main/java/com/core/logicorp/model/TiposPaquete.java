package com.core.logicorp.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "tipos_paquete")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TiposPaquete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, unique = true, length = 50)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio_base", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioBase;

    @Column(name = "peso_maximo_kg", nullable = false, precision = 5, scale = 2)
    private BigDecimal pesoMaximoKg;

    @Column(name = "requiere_firma", nullable = false)
    private boolean requiereFirma;

}
