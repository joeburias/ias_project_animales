package com.co.ias.project.animales.aves.application.services;

import com.co.ias.project.animales.aves.application.domain.Ave;
import com.co.ias.project.animales.aves.application.ports.input.ActualizarAveCasoDeUso;
import com.co.ias.project.animales.aves.application.ports.output.AveRepositorio;
import com.co.ias.project.animales.infranstructure.models.AveDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ActualizarAveServicio implements ActualizarAveCasoDeUso {
    private final AveRepositorio aveRepositorio;


    public ActualizarAveServicio(AveRepositorio aveRepositorio) {
        this.aveRepositorio = aveRepositorio;
    }


    @Override
    public AveDTO execute(AveDTO aveDTO) {
        Ave ave = aveDTO.toDomain();

        Optional<Ave> aveBD = aveRepositorio.get(ave.getAveId());

        if(aveBD.isPresent()) {
            aveRepositorio.update(ave);
            aveDTO.setStatus("Ave Actualizada!");
        } else {
            aveDTO.setStatus("Ave no actualizada...");
        }
        return aveDTO;
    }
}
