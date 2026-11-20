package com.core.logicorp.repository;

import com.core.logicorp.model.Vehiculo;
import com.core.logicorp.model.enums.EstadoVehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    List<Vehiculo> findByOficina_Id(Long oficinaId);
    List<Vehiculo> findByOficina_IdAndEstado(Long oficinaId, EstadoVehiculo estado);
}
