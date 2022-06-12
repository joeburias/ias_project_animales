package com.co.ias.project.animales.aves.application.domain.valueObjs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AveNombreComunTest {
    @Test
    @DisplayName("Nombre comun en nulo debería lanzar un error.")
    void null_nombre_comun() {
        String datoInvalido = null;
        assertThrows(NullPointerException.class, () -> {
            new AveNombreComun(datoInvalido);
        });
    }

    @Test
    @DisplayName("Nombre comun fuera del rango debería lanzar un error.")
    void rango_nombre_comun() {
        String datoInvalido = "THIS STRING IS TO EFFING LOOOOOOOOOOOOOOOOOOOOOOOONGGGGGGGGGGGGGGGGGGGG.";
        assertThrows(IllegalArgumentException.class, () -> {
            new AveNombreComun(datoInvalido);
        });
    }

    @Test
    @DisplayName("Nombre comun válido NO debería lanzar un error.")
    void valido_nombre_comun() {
        String datoValido = "Ave!";
        assertDoesNotThrow(() -> {
            new AveNombreComun(datoValido);
        });
    }

}