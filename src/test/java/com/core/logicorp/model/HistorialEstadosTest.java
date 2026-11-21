package com.core.logicorp.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class HistorialEstadosTest {

    private HistorialEstados historialEstados;

    @Test
    void onCreate_cuandoFechaHoraEsNull_asignaFechaHoraActual() {
        HistorialEstados historial = new HistorialEstados();

        historial.onCreate();

        assertNotNull(historial.getFechaHora());
    }

    @Test
    void onCreate_cuandoFechaHoraYaExiste_conservaElValor() {
        HistorialEstados historial = new HistorialEstados();
        LocalDateTime fechaFija = LocalDateTime.of(2026, 11, 21, 12, 0);
        historial.setFechaHora(fechaFija);

        historial.onCreate();

        assertEquals(fechaFija, historial.getFechaHora());
    }
}