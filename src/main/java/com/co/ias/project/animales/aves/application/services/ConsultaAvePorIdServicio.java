package com.co.ias.project.animales.aves.application.services;

import com.co.ias.project.animales.aves.application.domain.Ave;
import com.co.ias.project.animales.aves.application.domain.valueObjs.AveId;
import com.co.ias.project.animales.aves.application.ports.input.ConsultaAvePorIdCasoDeUso;
import com.co.ias.project.animales.aves.application.ports.output.AveRepositorio;
import com.co.ias.project.animales.infranstructure.models.AveDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ConsultaAvePorIdServicio implements ConsultaAvePorIdCasoDeUso {

    private final AveRepositorio aveRepositorio;

    public ConsultaAvePorIdServicio(AveRepositorio aveRepositorio) {
        this.aveRepositorio = aveRepositorio;
    }

    @Override
    public Optional<AveDTO> execute(Long id) {
        AveId aveId = new AveId(id);

        Optional<Ave> aveOptional = aveRepositorio.get(aveId);

        return aveOptional.map(ave -> {
            AveDTO aveDTO = AveDTO.fromDomain(ave);
            return aveDTO;
        });
    }
}
