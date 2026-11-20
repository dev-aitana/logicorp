package com.core.logicorp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "inventario_oficina",
        uniqueConstraints = @UniqueConstraint(name = "uk_oficina_articulo", columnNames = {"oficina_id", "articulo_id"}))
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InventarioOficina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "oficina_id", nullable = false)
    private Oficina oficinaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "articulo_id", nullable = false)
    private Articulo articuloId;

    @Column(name = "stock_actual", nullable = false)
    private Integer stock = 0;

    @Column(name = "stock_minimo", nullable = false)
    private Integer stockMinimo = 5;

}
