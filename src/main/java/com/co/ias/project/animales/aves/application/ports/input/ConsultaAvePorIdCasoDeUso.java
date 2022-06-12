package com.co.ias.project.animales.aves.application.ports.input;

import com.co.ias.project.animales.commons.UseCase;
import com.co.ias.project.animales.infranstructure.models.AveDTO;

import java.util.Optional;

public interface ConsultaAvePorIdCasoDeUso extends UseCase<Long, Optional<AveDTO>> {
}
