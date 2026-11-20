package com.core.logicorp.controller;

import com.core.logicorp.dto.VehiculoResponse;
import com.core.logicorp.model.enums.EstadoVehiculo;
import com.core.logicorp.service.OficinaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/oficinas")
public class OficinaController {

    private final OficinaService oficinaService;

    public OficinaController(OficinaService oficinaService) {
        this.oficinaService = oficinaService;
    }

    @GetMapping("/{oficinaId}/vehiculos")
    public ResponseEntity<List<VehiculoResponse>> getVehiculosDeOficina(@PathVariable Long oficinaId, @RequestParam(name = "estado", required = false) EstadoVehiculo estado) {
        return ResponseEntity.ok(oficinaService.obtenerVehiculosDeOficina(oficinaId, estado));
    }

}
