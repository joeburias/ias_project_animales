package com.co.ias.project.animales.aves.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class AveCantidadConfirmada {
    final private Integer value;

    public AveCantidadConfirmada(Integer value) {
        Validate.notNull(value, "La cantidad confirmada del ave no puede ser nula.");
        Validate.isTrue(value >= 1 && value <= 100000,
                "La cantidad confirmada del ave debe estar en el rango de 1 a 100000.");
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
