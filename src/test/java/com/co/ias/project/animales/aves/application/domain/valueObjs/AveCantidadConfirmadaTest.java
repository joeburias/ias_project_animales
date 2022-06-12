package com.co.ias.project.animales.aves.application.domain.valueObjs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AveCantidadConfirmadaTest {
    @Test
    @DisplayName("Cantidad confirmada en null debería lanzar un error.")
    void null_cantidad_confirmada() {
        Integer datoInvalido = null;
        assertThrows(NullPointerException.class, () -> {
            new AveCantidadConfirmada(datoInvalido);
        });
    }

    @Test
    @DisplayName("Cantidad confirmada fuera del rango debería lanzar un error.")
    void invalido_cantidad_confirmada() {
        Integer datoInvalido = 0;
        assertThrows(IllegalArgumentException.class, () -> {
            new AveCantidadConfirmada(datoInvalido);
        });
    }

    @Test
    @DisplayName("Cantidad confirmada válida NO debería lanzar un error.")
    void valido_cantidad_confirmada() {
        Integer datoValido = 800;
        assertDoesNotThrow(() -> {
            new AveCantidadConfirmada(datoValido);
        });
    }
}