package com.example.parcialfrancoback.Servicios;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.parcialfrancoback.Dtos.DTOContrato;
import com.example.parcialfrancoback.Modelos.Contrato;
import com.example.parcialfrancoback.Repositorios.RepositorioContrato;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ServicioContrato {

    @Autowired
    private RepositorioContrato repositorioContrato;

    @Autowired
    private ModelMapper modelMapper;

    public List<DTOContrato> traerContratos() {
        return repositorioContrato.findAll().stream()
                .map(contrato -> modelMapper.map(contrato, DTOContrato.class))
                .collect(Collectors.toList());
    }

    public DTOContrato traerContrato(Long id) {
        Contrato contrato = repositorioContrato.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Contrato no encontrado"));
        return modelMapper.map(contrato, DTOContrato.class);
  
    }

    public DTOContrato crearContrato(DTOContrato dtocontrato) {
        Contrato contrato = modelMapper.map(dtocontrato, Contrato.class);
        contrato = repositorioContrato.save(contrato);
        return modelMapper.map(contrato, DTOContrato.class);
   
    }

    public DTOContrato actualizarContrato(Long id, DTOContrato dtocontrato) {
        Contrato contrato = repositorioContrato.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Contrato no encontrado"));
        modelMapper.map(dtocontrato, contrato);
        contrato = repositorioContrato.save(contrato);
        return modelMapper.map(contrato, DTOContrato.class);
   
    }

    public void eliminarContrato(Long id) {
        if (!repositorioContrato.existsById(id)) {
            throw new EntityNotFoundException("Contrato no encontrado");
        }
        repositorioContrato.deleteById(id);
    }
    
}
