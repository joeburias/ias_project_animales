package com.co.ias.project.animales.infranstructure.controllers;

import com.co.ias.project.animales.aves.application.domain.Ave;
import com.co.ias.project.animales.aves.application.ports.input.ActualizarAveCasoDeUso;
import com.co.ias.project.animales.aves.application.ports.input.BorrarAveCasoDeUso;
import com.co.ias.project.animales.aves.application.ports.input.ConsultaAvePorIdCasoDeUso;
import com.co.ias.project.animales.aves.application.ports.input.CrearAveCasoDeUso;
import com.co.ias.project.animales.infranstructure.models.ApplicationError;
import com.co.ias.project.animales.infranstructure.models.AveDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
public class AveControlador {
    private final CrearAveCasoDeUso crearAveCasoDeUso;
    private final ActualizarAveCasoDeUso actualizarAveCasoDeUso;
    private final ConsultaAvePorIdCasoDeUso consultaAvePorIdCasoDeUso;
    private final BorrarAveCasoDeUso borrarAveCasoDeUso;

    public AveControlador(CrearAveCasoDeUso crearAveCasoDeUso, ActualizarAveCasoDeUso actualizarAveCasoDeUso,
                          ConsultaAvePorIdCasoDeUso consultaAvePorIdCasoDeUso, BorrarAveCasoDeUso borrarAveCasoDeUso) {
        this.crearAveCasoDeUso = crearAveCasoDeUso;
        this.actualizarAveCasoDeUso = actualizarAveCasoDeUso;
        this.consultaAvePorIdCasoDeUso = consultaAvePorIdCasoDeUso;
        this.borrarAveCasoDeUso = borrarAveCasoDeUso;
    }

    @RequestMapping(value = "/aves", method = RequestMethod.POST)
    public ResponseEntity<?> crearAve(@RequestBody AveDTO aveDTO) {
        try {
            AveDTO aveDTOOutput = crearAveCasoDeUso.execute(aveDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(aveDTOOutput);
        } catch (NullPointerException | IllegalArgumentException e) {
            ApplicationError applicationError = new ApplicationError("InputDataValidationError",
                    "Datos de ingreso erróneos.", Map.of("error", e.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(applicationError);
        } catch (Exception e) {
            ApplicationError applicationError = new ApplicationError("SystemError",
                    "Intenta más tarde...", Map.of());
            System.out.println("Error! Detalles: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(applicationError);
        }
    }

    @RequestMapping(value = "/aves/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> consultaAvePorId(@PathVariable("id") Long id) {
        try {
            Optional<AveDTO> aveDTO = consultaAvePorIdCasoDeUso.execute(id);
            if (aveDTO.isPresent()) {
                return ResponseEntity.ok(aveDTO.get());
            } else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No existe un ave con este ID!");
            }
        } catch (NullPointerException | IllegalArgumentException exception) {
            ApplicationError applicationError = new ApplicationError("InpuDataValidationError",
                    "Datos de ingreso erróneos.", Map.of("error", exception.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(applicationError);
        } catch (Exception exception) {
            ApplicationError applicationError = new ApplicationError("SystemError",
                    "Intenta más tarde...", Map.of());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(applicationError);
        }
    }

    @RequestMapping(value = "/aves", method = RequestMethod.PUT)
    public ResponseEntity<?> actualizarAve(@RequestBody AveDTO aveDTO) {
        try {
            AveDTO aveDTOOutput = actualizarAveCasoDeUso.execute(aveDTO);
            return ResponseEntity.ok(aveDTOOutput);
        } catch (NullPointerException | IllegalArgumentException exception) {
            ApplicationError applicationError = new ApplicationError("InpuDataValidationError",
                    "Datos de ingreso erróneos.", Map.of("error", exception.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(applicationError);
        } catch (Exception exception) {
            ApplicationError applicationError = new ApplicationError("SystemError",
                    "Intenta más tarde...", Map.of());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(applicationError);
        }
    }

    @RequestMapping(value="/aves/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> borrarAve(@PathVariable("id") Long id) {
        try {
            Boolean result = borrarAveCasoDeUso.execute(id);
            if (result) {
                return ResponseEntity.ok("Ave eliminada de la base de datos!");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El ave no pudo ser eliminada de " +
                        "la base de datos...");
            }
        } catch (NullPointerException | IllegalArgumentException exception) {
            ApplicationError applicationError = new ApplicationError("InpuDataValidationError",
                    "Datos de ingreso erróneos.", Map.of("error", exception.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(applicationError);
        } catch (Exception exception) {
            ApplicationError applicationError = new ApplicationError("SystemError",
                    "Intenta más tarde...", Map.of());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(applicationError);
        }
    }
}
