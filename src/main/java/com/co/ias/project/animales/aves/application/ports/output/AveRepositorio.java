package com.co.ias.project.animales.aves.application.ports.output;

import com.co.ias.project.animales.aves.application.domain.Ave;
import com.co.ias.project.animales.aves.application.domain.valueObjs.AveId;
import com.co.ias.project.animales.aves.application.domain.valueObjs.AveNombreCientifico;
import com.co.ias.project.animales.aves.application.domain.valueObjs.AveNombreComun;
import com.co.ias.project.animales.aves.application.domain.valueObjs.AveNombreZona;

import java.util.Optional;

public interface AveRepositorio {
    void store(Ave ave);

    Optional<Ave> get(AveId aveId);
    Optional<Ave> get(AveNombreComun aveNombreComun);
    Optional<Ave> get(AveNombreCientifico aveNombreCientifico);
    Optional<Ave> get(AveNombreZona aveNombreZona);

    void update(Ave ave);

    Boolean delete(AveId aveId);
}
