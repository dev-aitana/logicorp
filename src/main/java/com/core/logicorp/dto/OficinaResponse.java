package com.core.logicorp.dto;

import com.core.logicorp.model.Oficina;

public record OficinaResponse (Long id, String codigoOficina, String nombre, String direccion, String ciudad, String codigoPostal, boolean activa) {

    public static OficinaResponse fromEntity (Oficina c) {
        return new OficinaResponse(c.getId(), c.getCodigoOficina(), c.getNombre(), c.getDireccion(), c.getCiudad(), c.getCodigoPostal(), c.isActiva());
    }

}