package com.core.logicorp.service;

import com.core.logicorp.dto.VehiculoResponse;
import com.core.logicorp.model.Oficina;
import com.core.logicorp.model.Vehiculo;
import com.core.logicorp.model.enums.EstadoVehiculo;
import com.core.logicorp.repository.OficinaRepository;
import com.core.logicorp.repository.VehiculoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

@ExtendWith(MockitoExtension.class)
class OficinaServiceTest {

    @InjectMocks
    OficinaService oficinaService;

    @Mock
    private OficinaRepository oficinaRepository;

    @Mock
    private VehiculoRepository vehiculoRepository;

    @Test
    void obtenerVehiculosDeOficina_noexisteoficina() {

        Long oficinaId = 1L;

        Mockito.when(oficinaRepository.existsById(anyLong())).thenReturn(Boolean.FALSE);
        EntityNotFoundException e = assertThrows(EntityNotFoundException.class, () -> {
            oficinaService.obtenerVehiculosDeOficina(oficinaId, null);
        });

        verify(oficinaRepository).existsById(oficinaId);
        verifyNoInteractions(vehiculoRepository);
    }

    @Test
    void obtenerVehiculosDeOficina_existeoficina_sinvehiculos_sinestado() {

        Long oficinaId = 1L;

        Mockito.when(oficinaRepository.existsById(anyLong())).thenReturn(Boolean.TRUE);

        Mockito.when(vehiculoRepository.findByOficina_Id(anyLong())).thenReturn(new ArrayList<>());

        List<VehiculoResponse> vehiculos = oficinaService.obtenerVehiculosDeOficina(oficinaId, null);

        assertNotNull(vehiculos);
        assertTrue(vehiculos.isEmpty());
        verify(oficinaRepository).existsById(oficinaId);
        verify(vehiculoRepository).findByOficina_Id(oficinaId);
    }

    @Test
    void obtenerVehiculosDeOficina_existeoficina_sinvehiculos_conestado() {

        Long oficinaId = 1L;

        Mockito.when(oficinaRepository.existsById(anyLong())).thenReturn(Boolean.TRUE);

        Mockito.when(vehiculoRepository.findByOficina_IdAndEstado(anyLong(), any(EstadoVehiculo.class))).thenReturn(new ArrayList<>());

        List<VehiculoResponse> vehiculos = oficinaService.obtenerVehiculosDeOficina(oficinaId, EstadoVehiculo.DISPONIBLE);

        assertNotNull(vehiculos);
        assertTrue(vehiculos.isEmpty());
        verify(oficinaRepository).existsById(oficinaId);
        verify(vehiculoRepository).findByOficina_IdAndEstado(oficinaId, EstadoVehiculo.DISPONIBLE);
    }

    @Test
    void obtenerVehiculosDeOficina_existeoficina_convehiculos_sinestado() {

        Long oficinaId = 1L;
        List<Vehiculo> mockVehiculos = new ArrayList<>();
        Vehiculo v1 = new Vehiculo(oficinaId, "123M", "Seat", new BigDecimal("1.2"), EstadoVehiculo.DISPONIBLE, new Oficina());
        mockVehiculos.add(v1);

        Mockito.when(oficinaRepository.existsById(anyLong())).thenReturn(Boolean.TRUE);

        Mockito.when(vehiculoRepository.findByOficina_Id(anyLong())).thenReturn(mockVehiculos);

        List<VehiculoResponse> vehiculos = oficinaService.obtenerVehiculosDeOficina(oficinaId, null);

        assertNotNull(vehiculos);
        assertEquals(1, vehiculos.size());
        verify(oficinaRepository).existsById(oficinaId);
        verify(vehiculoRepository).findByOficina_Id(oficinaId);
    }

    @Test
    void obtenerVehiculosDeOficina_existeoficina_convehiculos_conestado() {

        Long oficinaId = 1L;
        List<Vehiculo> mockVehiculos = new ArrayList<>();
        Vehiculo v1 = new Vehiculo(oficinaId, "123M", "Seat", new BigDecimal("1.2"), EstadoVehiculo.DISPONIBLE, new Oficina());
        mockVehiculos.add(v1);

        Mockito.when(oficinaRepository.existsById(anyLong())).thenReturn(Boolean.TRUE);

        Mockito.when(vehiculoRepository.findByOficina_IdAndEstado(anyLong(), any(EstadoVehiculo.class))).thenReturn(mockVehiculos);

        List<VehiculoResponse> vehiculos = oficinaService.obtenerVehiculosDeOficina(oficinaId, EstadoVehiculo.DISPONIBLE);

        assertNotNull(vehiculos);
        assertEquals(1, vehiculos.size());
        verify(oficinaRepository).existsById(oficinaId);
        verify(vehiculoRepository).findByOficina_IdAndEstado(oficinaId, EstadoVehiculo.DISPONIBLE);
    }

}