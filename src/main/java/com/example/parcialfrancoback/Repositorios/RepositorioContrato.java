package com.example.parcialfrancoback.Repositorios;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.parcialfrancoback.Modelos.Contrato;

public interface RepositorioContrato extends JpaRepository<Contrato, Long> {

    Optional<Contrato> findById(Long id);
    boolean existsById(Long id);
    
}
