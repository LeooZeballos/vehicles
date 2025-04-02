package cl.myhotel.vehicles.service;

import cl.myhotel.vehicles.dto.MantenimientoDTO;
import cl.myhotel.vehicles.mapper.MantenimientoMapper;
import cl.myhotel.vehicles.model.Mantenimiento;
import cl.myhotel.vehicles.repository.MantenimientoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio para gestionar los mantenimientos de los vehículos.
 *
 * @author Leonel Zeballos
 */
@Service
@RequiredArgsConstructor
public class MantenimientoService {

    /**
     * Repositorio de mantenimientos.
     */
    private final MantenimientoRepository mantenimientoRepository;

    /**
     * Mapper para convertir entre entidades y DTOs de mantenimiento.
     */
    private final MantenimientoMapper mantenimientoMapper;

    /**
     * Obtiene todos los mantenimientos de un vehículo.
     *
     * @param vehiculoId ID del vehículo al que pertenece el mantenimiento.
     * @return DTO del mantenimiento guardado.
     */
    public List<MantenimientoDTO> getMantenimientos(Long vehiculoId) {
        List<Mantenimiento> mantenimientos = mantenimientoRepository.findAllByVehiculo_Id(vehiculoId);
        return mantenimientoMapper.toDTOs(mantenimientos);
    }

    /**
     * Obtiene un mantenimiento por su ID.
     *
     * @param id ID del mantenimiento.
     * @return DTO del mantenimiento guardado.
     */
    public MantenimientoDTO getMantenimientoById(Long id) {
        Mantenimiento mantenimiento = mantenimientoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mantenimiento no encontrado"));
        return mantenimientoMapper.toDTO(mantenimiento);
    }

}
