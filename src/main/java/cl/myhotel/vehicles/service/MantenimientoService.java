package cl.myhotel.vehicles.service;

import cl.myhotel.vehicles.dto.MantenimientoDTO;
import cl.myhotel.vehicles.mapper.MantenimientoMapper;
import cl.myhotel.vehicles.model.Mantenimiento;
import cl.myhotel.vehicles.model.Vehiculo;
import cl.myhotel.vehicles.repository.MantenimientoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Service to manage vehicle maintenance.
 *
 * @author Leonel Zeballos
 */
@Service
@RequiredArgsConstructor
public class MantenimientoService {

    /**
     * Maintenance repository.
     */
    private final MantenimientoRepository mantenimientoRepository;

    /**
     * Mapper to convert between maintenance entities and DTOs.
     */
    private final MantenimientoMapper mantenimientoMapper;

    /**
     * Service to manage vehicles.
     */
    private final VehiculoService vehiculoService;

    /**
     * Gets all maintenance records for a vehicle.
     *
     * @param vehiculoId ID of the vehicle to which the maintenance belongs.
     * @return DTO of the saved maintenance.
     */
    public List<MantenimientoDTO> getMantenimientos(Long vehiculoId) {
        List<Mantenimiento> mantenimientos = mantenimientoRepository.findAllByVehiculo_Id(vehiculoId);
        return mantenimientoMapper.toDTOs(mantenimientos);
    }

    /**
     * Gets a maintenance record by its ID.
     *
     * @param id ID of the maintenance.
     * @return DTO of the saved maintenance.
     */
    public MantenimientoDTO getMantenimientoById(Long id) {
        Mantenimiento mantenimiento = mantenimientoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mantenimiento no encontrado"));
        return mantenimientoMapper.toDTO(mantenimiento);
    }

    /**
     * Creates a new maintenance record.
     *
     * @param vehiculoId ID of the vehicle to which the maintenance belongs.
     * @param mantenimientoDTO DTO with the data to save.
     * @return DTO of the saved maintenance.
     */
    public MantenimientoDTO createMantenimiento(Long vehiculoId, MantenimientoDTO mantenimientoDTO) {
        Mantenimiento mantenimiento = mantenimientoMapper.toEntity(mantenimientoDTO);
        Vehiculo vehiculo = vehiculoService.getVehiculoById(vehiculoId);
        mantenimiento.setVehiculo(vehiculo);
        LocalDateTime now = LocalDateTime.now();
        mantenimiento.setCreatedAt(now);
        mantenimiento.setUpdatedAt(now);
        Mantenimiento savedMantenimiento = mantenimientoRepository.save(mantenimiento);
        return mantenimientoMapper.toDTO(savedMantenimiento);
    }

    /**
     * Updates a maintenance record.
     *
     * @param id ID of the maintenance to update.
     * @param mantenimientoDTO DTO with the updated data.
     * @return DTO of the updated maintenance.
     */
    public MantenimientoDTO updateMantenimiento(Long id, MantenimientoDTO mantenimientoDTO) {
        Mantenimiento mantenimientoSaved = mantenimientoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mantenimiento no encontrado"));
        mantenimientoMapper.updateEntityFromDTO(mantenimientoDTO, mantenimientoSaved);
        mantenimientoSaved.setUpdatedAt(LocalDateTime.now());
        Mantenimiento updatedMantenimiento = mantenimientoRepository.save(mantenimientoSaved);
        return mantenimientoMapper.toDTO(updatedMantenimiento);
    }

    /**
     * Deletes a maintenance record by its ID.
     *
     * @param id ID of the maintenance to delete.
     */
    public void deleteMantenimiento(Long id) {
        Mantenimiento mantenimiento = mantenimientoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mantenimiento no encontrado"));
        mantenimientoRepository.delete(mantenimiento);
    }

}
