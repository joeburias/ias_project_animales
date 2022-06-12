package com.co.ias.project.animales.aves.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class AveNombreZona {
    final private String value;

    public AveNombreZona(String value) {
        Validate.notNull(value, "El nombre de la zona del ave no puede ser nulo.");
        Validate.isTrue(value.length() <= 20, "El nombre de la zona del ave no puede contener más " +
                "de 20 caracteres.");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
