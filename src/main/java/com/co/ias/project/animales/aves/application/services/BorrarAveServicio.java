package com.co.ias.project.animales.aves.application.services;

import com.co.ias.project.animales.aves.application.domain.Ave;
import com.co.ias.project.animales.aves.application.domain.valueObjs.AveId;
import com.co.ias.project.animales.aves.application.ports.input.BorrarAveCasoDeUso;
import com.co.ias.project.animales.aves.application.ports.output.AveRepositorio;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BorrarAveServicio implements BorrarAveCasoDeUso {

    private final AveRepositorio aveRepositorio;

    public BorrarAveServicio(AveRepositorio aveRepositorio) {
        this.aveRepositorio = aveRepositorio;
    }

    @Override
    public Boolean execute(Long id) {
        AveId aveId = new AveId(id);

        Optional<Ave> ave = aveRepositorio.get(aveId);

        if (ave.isPresent()) {
            aveRepositorio.delete(aveId);
        }

        return ave.isPresent();
    }
}
