package com.co.ias.project.animales.aves.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class AveNombreCientifico {
    final private String value;

    public AveNombreCientifico(String value) {
        Validate.notNull(value, "El nombre científico del ave no puede ser nulo.");
        Validate.isTrue(value.length() <= 30, "El nombre científico del ave no puede contener " +
                "más de 30 caracteres.");
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
