package cl.myhotel.vehicles.mapper;

import cl.myhotel.vehicles.dto.VehiculoDTO;
import cl.myhotel.vehicles.model.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Mapper class for converting between Vehiculo and VehiculoDTO objects.
 * This class is responsible for mapping the properties of Vehiculo
 * to VehiculoDTO and vice versa.
 *
 * @author Leonel Zeballos
 */
@Component
public class VehiculoMapper {

    /**
     * Converts a Vehiculo entity to a VehiculoDTO.
     *
     * @param vehiculo The Vehiculo entity to convert.
     * @return The converted VehiculoDTO.
     */
    public VehiculoDTO toDTO(Vehiculo vehiculo) {
        if (vehiculo == null) {
            return null;
        }

        VehiculoDTO dto = new VehiculoDTO();
        dto.setId(vehiculo.getId());
        dto.setMarca(vehiculo.getMarca());
        dto.setModelo(vehiculo.getModelo());
        dto.setPatente(vehiculo.getPatente());
        dto.setAnio(vehiculo.getAnio());
        dto.setKilometraje(vehiculo.getKilometraje());
        dto.setCilindrada(vehiculo.getCilindrada());

        if (vehiculo instanceof Automovil automovil) {
            dto.setTipoVehiculo("automovil");
            dto.setTipoAuto(automovil.getTipoAuto().getNombre());
            dto.setNumPuertas(automovil.getNumPuertas());
            dto.setCapacidadPasajeros(automovil.getCapacidadPasajeros());
            dto.setCapacidadMaletero(automovil.getCapacidadMaletero());
        } else if (vehiculo instanceof Camion camion) {
            dto.setTipoVehiculo("camion");
            dto.setTipoCamion(camion.getTipoCamion().getNombre());
            dto.setCapacidadToneladas(camion.getCapacidadToneladas().toString());
            dto.setCantidadEjes(camion.getCantidadEjes());
        } else {
            dto.setTipoVehiculo("vehiculo");
        }

        return dto;
    }

    /**
     * Converts a VehiculoDTO to a Vehiculo entity.
     *
     * @param dto The VehiculoDTO to convert.
     * @return The converted Vehiculo entity.
     */
    public Vehiculo toEntity(VehiculoDTO dto) {
        if (dto == null) {
            return null;
        }

        Vehiculo vehiculo;

        switch (dto.getTipoVehiculo()) {
            case "automovil" -> {
                Automovil automovil = new Automovil();
                automovil.setTipoAuto(TipoAutomovil.getTipoByNombre(dto.getTipoAuto()));
                automovil.setNumPuertas(dto.getNumPuertas());
                automovil.setCapacidadPasajeros(dto.getCapacidadPasajeros());
                automovil.setCapacidadMaletero(dto.getCapacidadMaletero());
                vehiculo = automovil;
            }
            case "camion" -> {
                Camion camion = new Camion();
                camion.setTipoCamion(TipoCamion.getTipoByNombre(dto.getTipoCamion()));
                camion.setCapacidadToneladas(Double.parseDouble(dto.getCapacidadToneladas()));
                camion.setCantidadEjes(dto.getCantidadEjes());
                vehiculo = camion;
            }
            default -> vehiculo = new Vehiculo();
        }

        vehiculo.setId(dto.getId());
        vehiculo.setMarca(dto.getMarca());
        vehiculo.setModelo(dto.getModelo());
        vehiculo.setPatente(dto.getPatente());
        vehiculo.setAnio(dto.getAnio());
        vehiculo.setKilometraje(dto.getKilometraje());
        vehiculo.setCilindrada(dto.getCilindrada());

        return vehiculo;
    }

    /**
     * Converts a list of Vehiculo entities to a list of VehiculoDTOs.
     *
     * @param vehiculos The list of Vehiculo entities to convert.
     * @return The converted list of VehiculoDTOs.
     */
    @SuppressWarnings("unused")
    public List<VehiculoDTO> toDTOList(List<Vehiculo> vehiculos) {
        if (vehiculos == null || vehiculos.isEmpty()) {
            return List.of();
        }
        return vehiculos.stream()
                .map(this::toDTO)
                .toList();
    }

    /**
     * Converts a list of VehiculoDTOs to a list of Vehiculo entities.
     *
     * @param dtos The list of VehiculoDTOs to convert.
     * @return The converted list of Vehiculo entities.
     */
    @SuppressWarnings("unused")
    public List<Vehiculo> toEntityList(List<VehiculoDTO> dtos) {
        if (dtos == null || dtos.isEmpty()) {
            return List.of();
        }
        return dtos.stream()
                .map(this::toEntity)
                .toList();
    }

}
