package com.core.logicorp.exception;

import com.core.logicorp.dto.ExceptionResponse;
import com.core.logicorp.model.enums.EstadoVehiculo;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GlobalExceptionHandlerTest {

    @InjectMocks
    GlobalExceptionHandler globalExceptionHandler;

    @Test
    void handle404() {
        EntityNotFoundException exEntityNF = new EntityNotFoundException("No existe la oficina con ID: 1");

        ExceptionResponse response = globalExceptionHandler.handle404(exEntityNF);

        assertNotNull(response);
        assertEquals("404", response.getStatus());
        assertEquals("No existe la oficina con ID: 1", response.getMessage());
    }

    @Test
    void handle400_requiredTypeEsNull_devuelveTipoDesconocido() {
        MethodArgumentTypeMismatchException ex = new MethodArgumentTypeMismatchException(
                "abc", null, "parametro", null, new IllegalArgumentException("error"));

        ExceptionResponse response = globalExceptionHandler.handle400(ex);

        assertEquals("400", response.getStatus());
        assertTrue(response.getMessage().contains("desconocido"));
    }

    @Test
    void handle400_enum_novalido() {
        MethodArgumentTypeMismatchException ex = new MethodArgumentTypeMismatchException(
                "KK",
                EstadoVehiculo.class,
                "filtro",
                null,
                null
        );

        ExceptionResponse response = globalExceptionHandler.handle400(ex);

        assertNotNull(response);
        assertEquals("400", response.getStatus());
        assertEquals("Valor no válido 'KK' para el parámetro 'filtro'. Valores permitidos: [DISPONIBLE, EN_RUTA, MANTENIMIENTO]", response.getMessage());
    }

    @Test
    void handle400_parametro_novalido() {
        MethodArgumentTypeMismatchException ex = new MethodArgumentTypeMismatchException(
                "abc",
                Long.class,
                "oficinaId",
                null,
                null
        );

        ExceptionResponse response = globalExceptionHandler.handle400(ex);

        assertNotNull(response);
        assertEquals("400", response.getStatus());
        assertEquals("Valor no válido 'abc' para el parámetro 'oficinaId'. Se esperaba un valor de tipo Long", response.getMessage());
    }
}