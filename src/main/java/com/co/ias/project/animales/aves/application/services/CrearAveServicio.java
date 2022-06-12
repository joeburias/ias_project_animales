package com.co.ias.project.animales.aves.application.services;

import com.co.ias.project.animales.aves.application.domain.Ave;
import com.co.ias.project.animales.aves.application.domain.valueObjs.*;
import com.co.ias.project.animales.aves.application.ports.input.CrearAveCasoDeUso;
import com.co.ias.project.animales.aves.application.ports.output.AveRepositorio;
import com.co.ias.project.animales.infranstructure.models.AveDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CrearAveServicio implements CrearAveCasoDeUso {
    private final AveRepositorio aveRepositorio;

    public CrearAveServicio(AveRepositorio aveRepositorio) {
        this.aveRepositorio = aveRepositorio;
    }

    @Override
    public AveDTO execute(AveDTO aveDTO) {
        Boolean crear = true;

        Ave aveBD = aveDTO.toDomain();

        Optional<Ave> avePorNombreComun = aveRepositorio.get(aveBD.getAveNombreComun());
        Optional<Ave> avePorNombreCientifico = aveRepositorio.get(aveBD.getAveNombreCientifico());
        Optional<Ave> aveporZona = aveRepositorio.get(aveBD.getAveNombreZona());

        if(avePorNombreComun.isPresent()){
            aveDTO.setStatus("Ave no creada ya que existe un ave con el mismo nombre común.");
            crear = false;
        }

        if(avePorNombreCientifico.isPresent()){
            aveDTO.setStatus("Ave no creada ya que existe un ave con el mismo nombre científico.");
            crear = false;
        }

        if(aveporZona.isPresent()){
            aveDTO.setStatus("Ave no creada ya que existe un ave en la misma zona.");
            crear = false;
        }

        if(crear) {
            Ave ave = new Ave(null,
                    new AveNombreComun(aveDTO.getNombreComun()),
                    new AveNombreCientifico(aveDTO.getNombreCientifico()),
                    new AveNombreZona(aveDTO.getZona()),
                    new AveCantidadConfirmada(aveDTO.getCantidadConfirmada()));
            aveRepositorio.store(ave);
            aveDTO.setStatus("Ave creada exitosamente!.");
        }

        return aveDTO;
    }
}
