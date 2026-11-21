package com.core.logicorp.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaqueteTest {

    private Paquete paquete = new Paquete();
    
    @Test
    void onCreate_cuandoFechaHoraEsNull_asignaFechaHoraActual() {

        paquete.onCreate();

        assertNotNull(paquete.getFechaCreacion());
    }
}