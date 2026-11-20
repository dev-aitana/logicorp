package com.core.logicorp.service;

import com.core.logicorp.dto.VehiculoResponse;
import com.core.logicorp.repository.OficinaRepository;
import com.core.logicorp.repository.VehiculoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OficinaService {

    private final OficinaRepository oficinaRepository;
    private final VehiculoRepository vehiculoRepository;

    public OficinaService(OficinaRepository oficinaRepository, VehiculoRepository vehiculoRepository) {
        this.oficinaRepository = oficinaRepository;
        this.vehiculoRepository = vehiculoRepository;
    }

    @Transactional(readOnly = true)
    public List<VehiculoResponse> obtenerVehiculosDeOficina(Long oficinaId) {
        if( !oficinaRepository.existsById(oficinaId)) {
            throw new EntityNotFoundException("No existe la oficina con ID: " + oficinaId);
        }

        return vehiculoRepository.findByOficina_Id(oficinaId)
                .stream()
                .map(VehiculoResponse::fromEntity)
                .toList();
    }

}
