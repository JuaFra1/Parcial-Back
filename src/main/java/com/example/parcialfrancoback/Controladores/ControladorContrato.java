package com.example.parcialfrancoback.Controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.parcialfrancoback.Dtos.DTOContrato;
import com.example.parcialfrancoback.Servicios.ServicioContrato;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/contrato")
public class ControladorContrato {

    @Autowired
    private ServicioContrato servicioContrato;

    @GetMapping("/get")
    public List<DTOContrato> getContratos() {
        return servicioContrato.traerContratos();
    }

    @GetMapping("/get/{id}")
    public DTOContrato getContrato(@PathVariable Long id) {
        return servicioContrato.traerContrato(id);
    }

    @PostMapping("/post")
    public DTOContrato postContrato(@RequestBody DTOContrato contrato) {
        return servicioContrato.crearContrato(contrato);
    }

    @PutMapping("/put/{id}")
    public DTOContrato putContrato(@PathVariable Long id, @RequestBody DTOContrato contrato) {
        return servicioContrato.actualizarContrato(id, contrato);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteContrato(@PathVariable Long id) {
        try {
            servicioContrato.eliminarContrato(id);
            return ResponseEntity.ok("Estudiante eliminado con éxito.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudiante no encontrado.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el estudiante.");
        }
    }
    
}
