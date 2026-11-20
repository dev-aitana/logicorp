package com.core.logicorp.controller;

import com.core.logicorp.dto.VehiculoResponse;
import com.core.logicorp.service.OficinaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/oficinas")
public class OficinaController {

    private final OficinaService oficinaService;

    public OficinaController(OficinaService oficinaService) {
        this.oficinaService = oficinaService;
    }

    @GetMapping("/{oficinaId}/vehiculos")
    public ResponseEntity<List<VehiculoResponse>> getVehiculosDeOficina(@PathVariable Long oficinaId) {
        return ResponseEntity.ok(oficinaService.obtenerVehiculosDeOficina(oficinaId));
    }

}
