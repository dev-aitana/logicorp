package com.core.logicorp.controller;

import com.core.logicorp.dto.VehiculoResponse;
import com.core.logicorp.model.enums.EstadoVehiculo;
import com.core.logicorp.service.OficinaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OficinaControllerTest {

    @InjectMocks
    OficinaController oficinaController;

    @Mock
    OficinaService oficinaService;

    @Test
    void getVehiculosDeOficina_estadook() {
        when(oficinaService.obtenerVehiculosDeOficina(anyLong(), any(EstadoVehiculo.class))).thenReturn(new ArrayList<>());
        ResponseEntity<List<VehiculoResponse>> r = oficinaController.getVehiculosDeOficina(1L, EstadoVehiculo.DISPONIBLE);

        assertNotNull(r);
        assertEquals(HttpStatus.OK, r.getStatusCode());
    }

    @Test
    void getVehiculosDeOficina_estadonull() {
        Long oficinaId = 1L;

        when(oficinaService.obtenerVehiculosDeOficina(oficinaId, null)).thenReturn(new ArrayList<>());
        ResponseEntity<List<VehiculoResponse>> r = oficinaController.getVehiculosDeOficina(oficinaId, null);

        assertNotNull(r);
        assertEquals(HttpStatus.OK, r.getStatusCode());
    }

}