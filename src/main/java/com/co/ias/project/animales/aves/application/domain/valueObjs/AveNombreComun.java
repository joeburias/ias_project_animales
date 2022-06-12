package com.co.ias.project.animales.aves.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class AveNombreComun {
    final private String value;

    public AveNombreComun(String value) {
        Validate.notNull(value, "El nombre común del ave no puede ser nulo.");
        Validate.isTrue(value.length() <= 30, "El nombre común del ave no puede contener más de " +
                "30 caracteres.");
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
