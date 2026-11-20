package com.core.logicorp.dto;

import com.core.logicorp.model.Vehiculo;
import com.core.logicorp.model.enums.EstadoVehiculo;

import java.math.BigDecimal;

public record VehiculoResponse(Long id, String matricula, String modelo, BigDecimal capacidadKg, EstadoVehiculo estado, Long oficinaId) {
    public static VehiculoResponse  fromEntity (Vehiculo v){
        return new VehiculoResponse(v.getId(), v.getMatricula(), v.getModelo(), v.getCapacidadKg(), v.getEstado(), v.getOficina().getId());
    }
}
