package com.co.ias.project.animales.infranstructure.models;

import com.co.ias.project.animales.aves.application.domain.Ave;
import com.co.ias.project.animales.aves.application.domain.valueObjs.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AveDAO {
    private Long aveId;
    private String nombreComun;
    private String nombreCientifico;
    private String zona;
    private Integer cantidadConfirmada;

    public AveDAO(Long aveId, String nombreComun, String nombreCientifico, String zona, Integer cantidadConfirmada) {
        this.aveId = aveId;
        this.nombreComun = nombreComun;
        this.nombreCientifico = nombreCientifico;
        this.zona = zona;
        this.cantidadConfirmada = cantidadConfirmada;
    }

    public AveDAO() {
    }

    public Ave toDomain() {
        return new Ave(
                new AveId(aveId),
                new AveNombreComun(nombreComun),
                new AveNombreCientifico(nombreCientifico),
                new AveNombreZona(zona),
                new AveCantidadConfirmada(cantidadConfirmada));
    }

    public static AveDAO fromDomain(Ave ave) {
        AveDAO aveDAO = new AveDAO(
                ave.getAveId().getValue(),
                ave.getAveNombreComun().getValue(),
                ave.getAveNombreCientifico().getValue(),
                ave.getAveNombreZona().getValue(),
                ave.getAveCantidadConfirmada().getValue());
        return aveDAO;
    }

    public static AveDAO fromResultSet(ResultSet resultSet) throws SQLException {
        AveDAO productDAO = new AveDAO();
        productDAO.setAveId(resultSet.getLong("id"));
        productDAO.setNombreComun(resultSet.getString("nombre_comun"));
        productDAO.setNombreCientifico(resultSet.getString("nombre_cientifico"));
        productDAO.setZona(resultSet.getString("nombre_zona"));
        productDAO.setCantidadConfirmada(resultSet.getInt("cantidad_confirmada"));
        return productDAO;
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
}
