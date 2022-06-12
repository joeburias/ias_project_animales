package com.co.ias.project.animales.aves.application.domain.valueObjs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AveIdTest {
    @Test
    @DisplayName("ID en nulo debería lanzar un error.")
    void null_ave_id() {
        Long datoInvalido = null;
        assertThrows(NullPointerException.class, () -> {
            new AveId(datoInvalido);
        });
    }

    @Test
    @DisplayName("ID válido NO debería lanzar un error.")
    void valido_ave_id() {
        Long datoValido = 8L;
        assertDoesNotThrow(() -> {
            new AveId(datoValido);
        });
    }
}