package com.co.ias.project.animales.aves.application.domain;

import com.co.ias.project.animales.aves.application.domain.valueObjs.*;

public class Ave {
    private final AveId aveId;
    private final AveNombreComun aveNombreComun;
    private final AveNombreCientifico aveNombreCientifico;
    private final AveNombreZona aveNombreZona;
    private final AveCantidadConfirmada aveCantidadConfirmada;

    public Ave(AveId aveId, AveNombreComun aveNombreComun, AveNombreCientifico aveNombreCientifico,
               AveNombreZona aveNombreZona, AveCantidadConfirmada aveCantidadConfirmada) {
        this.aveId = aveId;
        this.aveNombreComun = aveNombreComun;
        this.aveNombreCientifico = aveNombreCientifico;
        this.aveNombreZona = aveNombreZona;
        this.aveCantidadConfirmada = aveCantidadConfirmada;
    }

    public AveId getAveId() {
        return aveId;
    }

    public AveNombreComun getAveNombreComun() {
        return aveNombreComun;
    }

    public AveNombreCientifico getAveNombreCientifico() {
        return aveNombreCientifico;
    }

    public AveNombreZona getAveNombreZona() {
        return aveNombreZona;
    }

    public AveCantidadConfirmada getAveCantidadConfirmada() {
        return aveCantidadConfirmada;
    }

    @Override
    public String toString() {
        return "Ave{" +
                "aveId=" + aveId +
                ", aveNombreComun=" + aveNombreComun +
                ", aveNombreCientifico=" + aveNombreCientifico +
                ", aveNombreZona=" + aveNombreZona +
                ", aveCantidadConfirmada=" + aveCantidadConfirmada +
                '}';
    }
}
