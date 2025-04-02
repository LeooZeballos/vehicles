package cl.myhotel.vehicles.mapper;

import cl.myhotel.vehicles.dto.VehiculoDTO;
import cl.myhotel.vehicles.model.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VehiculoMapper {

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
            dto.setTipoAuto(automovil.getTipoAuto().name());
            dto.setNumPuertas(automovil.getNumPuertas());
            dto.setCapacidadPasajeros(automovil.getCapacidadPasajeros());
            dto.setCapacidadMaletero(automovil.getCapacidadMaletero());
        } else if (vehiculo instanceof Camion camion) {
            dto.setTipoVehiculo("camion");
            dto.setTipoCamion(camion.getTipoCamion().name());
            dto.setCapacidadToneladas(camion.getCapacidadToneladas().toString());
            dto.setCantidadEjes(camion.getCantidadEjes());
        } else {
            dto.setTipoVehiculo("vehiculo");
        }

        return dto;
    }

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

    @SuppressWarnings("unused")
    public List<VehiculoDTO> toDTOList(List<Vehiculo> vehiculos) {
        if (vehiculos == null || vehiculos.isEmpty()) {
            return List.of();
        }
        return vehiculos.stream()
                .map(this::toDTO)
                .toList();
    }

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
