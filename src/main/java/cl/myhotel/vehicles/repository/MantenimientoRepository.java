package cl.myhotel.vehicles.repository;

import cl.myhotel.vehicles.model.Mantenimiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repositorio para gestionar los mantenimientos de los vehículos.
 *
 * @author Leonel Zeballos
 */
public interface MantenimientoRepository extends JpaRepository<Mantenimiento, Long> {
    List<Mantenimiento> findAllByVehiculo_Id(Long vehiculoId);
}
