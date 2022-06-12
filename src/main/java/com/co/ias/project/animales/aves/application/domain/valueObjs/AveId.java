package com.co.ias.project.animales.aves.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class AveId {
    private final Long value;

    public AveId(Long value) {
        Validate.notNull(value, "El identificador del ave no puede ser nulo.");
        Validate.isTrue(value.toString().length() <= 8,
                "El identificador del ave no puede ser mayor a 8 caracteres.");
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
