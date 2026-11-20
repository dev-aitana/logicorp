package com.core.logicorp.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "oficinas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Oficina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_oficina", nullable = false, unique = true, length = 20)
    private String codigoOficina;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "ciudad", nullable = false, length = 100)
    private String ciudad;

    @Column(name = "codigo_postal", nullable = false, length = 10)
    private String codigoPostal;

    @Column(name = "activa", nullable = false)
    private boolean activa = Boolean.TRUE;

    @OneToMany(mappedBy = "oficinaId")
    private List<Empleado> empleados;

    @OneToMany(mappedBy = "oficina")
    private List<Vehiculo> vehiculos;

}
