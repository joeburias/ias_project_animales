package com.co.ias.project.animales.infranstructure.models;

import com.co.ias.project.animales.aves.application.domain.Ave;
import com.co.ias.project.animales.aves.application.domain.valueObjs.*;

public class AveDTO {
    private Long aveId;
    private String nombreComun;
    private String nombreCientifico;
    private String zona;
    private Integer cantidadConfirmada;
    private String status;

    public AveDTO(Long aveId, String nombreComun, String nombreCientifico, String zona, Integer cantidadConfirmada,
                  String status) {
        this.aveId = aveId;
        this.nombreComun = nombreComun;
        this.nombreCientifico = nombreCientifico;
        this.zona = zona;
        this.cantidadConfirmada = cantidadConfirmada;
        this.status = status;
    }

    public AveDTO() {
    }

    public Ave toDomain() {
        return new Ave(
                new AveId(aveId),
                new AveNombreComun(nombreComun),
                new AveNombreCientifico(nombreCientifico),
                new AveNombreZona(zona),
                new AveCantidadConfirmada(cantidadConfirmada)
                );
    }

    public static AveDTO fromDomain(Ave ave) {
        AveDTO aveDTO = new AveDTO();
        aveDTO.setAveId(ave.getAveId().getValue());
        aveDTO.setNombreComun(ave.getAveNombreComun().getValue());
        aveDTO.setNombreCientifico(ave.getAveNombreCientifico().getValue());
        aveDTO.setZona(ave.getAveNombreZona().getValue());
        aveDTO.setCantidadConfirmada(ave.getAveCantidadConfirmada().getValue());
        return aveDTO;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getAveId() {
        return aveId;
    }

    public void setAveId(Long aveId) {
        this.aveId = aveId;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public Integer getCantidadConfirmada() {
        return cantidadConfirmada;
    }

    public void setCantidadConfirmada(Integer cantidadConfirmada) {
        this.cantidadConfirmada = cantidadConfirmada;
    }

    @Override
    public String toString() {
        return "AveDTO{" +
                "aveId=" + aveId +
                ", nombreComun='" + nombreComun + '\'' +
                ", nombreCientifico='" + nombreCientifico + '\'' +
                ", zona='" + zona + '\'' +
                ", cantidadConfirmada=" + cantidadConfirmada +
                '}';
    }
}
