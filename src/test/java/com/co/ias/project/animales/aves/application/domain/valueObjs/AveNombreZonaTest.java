package com.co.ias.project.animales.aves.application.domain.valueObjs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AveNombreZonaTest {
    @Test
    @DisplayName("Nombre zona en nulo debería lanzar un error.")
    void null_nombre_zona() {
        String datoInvalido = null;
        assertThrows(NullPointerException.class, () -> {
            new AveNombreZona(datoInvalido);
        });
    }

    @Test
    @DisplayName("Nombre zona fuera del rango debería lanzar un error.")
    void rango_nombre_zona() {
        String datoInvalido = "THIS STRING IS TO EFFING LOOOOOOOOOOOOOOOOOOOOOOOONGGGGGGGGGGGGGGGGGGGG.";
        assertThrows(IllegalArgumentException.class, () -> {
            new AveNombreZona(datoInvalido);
        });
    }

    @Test
    @DisplayName("Nombre zona válido NO debería lanzar un error.")
    void valido_nombre_zona() {
        String datoValido = "Perú!";
        assertDoesNotThrow(() -> {
            new AveNombreZona(datoValido);
        });
    }

}