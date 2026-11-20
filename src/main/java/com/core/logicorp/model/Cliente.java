package com.core.logicorp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "clientes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "documento_identidad", unique = true, nullable = false, length = 20)
    private String dni;

    @Column(name = "nombre_o_razon_social", nullable = false, length = 150)
    private String nombreRazonSocial;

    @Column(name = "email", unique = true, nullable = false, length = 150)
    private String email;

    @Column(name = "telefono",length = 20)
    private String telefono;

    @Column(name = "direccion_fiscal")
    private String direccion;

    @Column(name = "es_empresa", nullable = false)
    private boolean esEmpresa;

    @Column(name = "descuento_porcentaje", precision = 5, scale = 2)
    private BigDecimal descuento = BigDecimal.ZERO;

    @Column(name = "activo",nullable = false)
    private boolean activo = Boolean.TRUE;

}
