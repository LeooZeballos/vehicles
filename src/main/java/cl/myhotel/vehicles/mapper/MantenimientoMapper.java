package cl.myhotel.vehicles.mapper;

import cl.myhotel.vehicles.dto.MantenimientoDTO;
import cl.myhotel.vehicles.model.Mantenimiento;
import cl.myhotel.vehicles.model.TipoMantenimiento;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Mapper class for converting between Mantenimiento and MantenimientoDTO objects.
 * This class is responsible for mapping the properties of Mantenimiento
 * to MantenimientoDTO and vice versa.
 *
 * @author Leonel Zeballos
 */
@Component
@RequiredArgsConstructor
public class MantenimientoMapper {

    /**
     * The vehiculo mapper.
     */
    private final VehiculoMapper vehiculoMapper;

    /**
     * Converts a Mantenimiento entity to a MantenimientoDTO.
     *
     * @param m The Mantenimiento entity to convert.
     * @return The converted MantenimientoDTO.
     */
    public MantenimientoDTO toDTO(Mantenimiento m) {
        if (m == null) {
            return null;
        }

        MantenimientoDTO dto = new MantenimientoDTO();
        dto.setId(m.getId());
        dto.setTipoMantenimiento(m.getTipoMantenimiento().getNombre());
        dto.setCreatedAt(m.getCreatedAt());
        dto.setUpdatedAt(m.getUpdatedAt());
        dto.setObservaciones(m.getObservaciones());

        if (m.getVehiculo() != null) {
            dto.setVehiculoDTO(vehiculoMapper.toDTO(m.getVehiculo()));
        }

        return dto;
    }

    /**
     * Converts a MantenimientoDTO to a Mantenimiento entity.
     *
     * @param dto The MantenimientoDTO to convert.
     * @return The converted Mantenimiento entity.
     */
    public Mantenimiento toEntity(MantenimientoDTO dto) {
        if (dto == null) {
            return null;
        }

        Mantenimiento m = new Mantenimiento();
        m.setTipoMantenimiento(TipoMantenimiento.getTipoByNombre(dto.getTipoMantenimiento()));
        m.setObservaciones(dto.getObservaciones());
        m.setCreatedAt(dto.getCreatedAt());
        m.setUpdatedAt(dto.getUpdatedAt());

        if (dto.getVehiculoDTO() != null) {
            m.setVehiculo(vehiculoMapper.toEntity(dto.getVehiculoDTO()));
        }

        return m;
    }

    /**
     * Converts a list of MantenimientoDTOs to a list of Mantenimiento entities.
     *
     * @param dtos The list of MantenimientoDTOs to convert.
     * @return The converted list of Mantenimiento entities.
     */
    @SuppressWarnings("unused")
    public List<Mantenimiento> toEntities(List<MantenimientoDTO> dtos) {
        if (dtos == null) {
            return null;
        }

        return dtos.stream()
                .map(this::toEntity)
                .toList();
    }

    /**
     * Converts a list of Mantenimiento entities to a list of MantenimientoDTOs.
     *
     * @param ms The list of Mantenimiento entities to convert.
     * @return The converted list of MantenimientoDTOs.
     */
    @SuppressWarnings("unused")
    public List<MantenimientoDTO> toDTOs(List<Mantenimiento> ms) {
        if (ms == null) {
            return null;
        }

        return ms.stream()
                .map(this::toDTO)
                .toList();
    }

}
