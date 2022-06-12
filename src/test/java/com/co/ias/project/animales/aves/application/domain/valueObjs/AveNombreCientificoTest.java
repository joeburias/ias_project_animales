package com.co.ias.project.animales.aves.application.domain.valueObjs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AveNombreCientificoTest {
    @Test
    @DisplayName("Nombre científico en nulo debería lanzar un error.")
    void null_nombre_cientifico() {
        String datoInvalido = null;
        assertThrows(NullPointerException.class, () -> {
            new AveNombreCientifico(datoInvalido);
        });
    }

    @Test
    @DisplayName("Nombre científico fuera del rango debería lanzar un error.")
    void rango_nombre_cientifico() {
        String datoInvalido = "THIS STRING IS TO EFFING LOOOOOOOOOOOOOOOOOOOOOOOONGGGGGGGGGGGGGGGGGGGG.";
        assertThrows(IllegalArgumentException.class, () -> {
            new AveNombreCientifico(datoInvalido);
        });
    }

    @Test
    @DisplayName("Nombre científico válido NO debería lanzar un error.")
    void valido_nombre_cientifico() {
        String datoValido = "Ave!";
        assertDoesNotThrow(() -> {
            new AveNombreCientifico(datoValido);
        });
    }
}