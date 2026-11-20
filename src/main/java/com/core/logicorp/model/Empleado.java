package com.core.logicorp.model;

import com.core.logicorp.model.enums.RolEmpleado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "empleados")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dni", nullable = false, unique = true, length = 15)
    private String dni;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellidos",nullable = false, length = 150)
    private String apellidos;

    @Column(name = "email",nullable = false, unique = true, length = 150)
    private String email;

    @Column(name = "telefono",length = 20)
    private String telefono;

    @Column(name = "rol",nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private RolEmpleado rol;

    @Column(name = "activo",nullable = false)
    private boolean activo = Boolean.TRUE;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "oficina_id", nullable = false)
    private Oficina oficinaId;

}
