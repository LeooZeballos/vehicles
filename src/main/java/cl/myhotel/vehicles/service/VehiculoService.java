package cl.myhotel.vehicles.service;

import cl.myhotel.vehicles.dto.VehiculoDTO;
import cl.myhotel.vehicles.mapper.VehiculoMapper;
import cl.myhotel.vehicles.model.Vehiculo;
import cl.myhotel.vehicles.query.AutomovilQueryParams;
import cl.myhotel.vehicles.query.CamionQueryParams;
import cl.myhotel.vehicles.query.VehiculoQueryParams;
import cl.myhotel.vehicles.repository.VehiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehiculoService {

    private final VehiculoRepository vehiculoRepository;
    private final VehiculoMapper vehiculoMapper;

    public Vehiculo getVehiculoById(Long id) {
        return vehiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado"));
    }

    public Page<?> getAllVehiculos(
            String marca,
            String modelo,
            String patente,
            Integer anio,
            Integer kilometraje,
            Integer cilindrada,
            String tipo,
            String tipoAuto,
            String tipoCamion,
            Integer numPuertas,
            Integer capacidadPasajeros,
            Integer capacidadMaletero,
            Double capacidadToneladas,
            Integer cantidadEjes,
            Pageable pageable
    ) {
        if (tipo == null || tipo.equals("ALL")) {
            VehiculoQueryParams queryParams = VehiculoQueryParams.builder()
                    .marca(marca)
                    .modelo(modelo)
                    .patente(patente)
                    .anio(anio)
                    .kilometraje(kilometraje)
                    .cilindrada(cilindrada)
                    .build();

            return vehiculoRepository.findAllByParams(queryParams, pageable);
        } else if (tipo.equals("AUTOMOVIL")) {
            AutomovilQueryParams queryParams = AutomovilQueryParams.builder()
                    .marca(marca)
                    .modelo(modelo)
                    .patente(patente)
                    .anio(anio)
                    .kilometraje(kilometraje)
                    .cilindrada(cilindrada)
                    .tipoAuto(tipoAuto)
                    .numPuertas(numPuertas)
                    .capacidadPasajeros(capacidadPasajeros)
                    .capacidadMaletero(capacidadMaletero)
                    .build();
            return vehiculoRepository.findAllAutomovilesByParams(queryParams, pageable);
        } else if (tipo.equals("CAMION")) {
            CamionQueryParams queryParams = CamionQueryParams.builder()
                    .marca(marca)
                    .modelo(modelo)
                    .patente(patente)
                    .anio(anio)
                    .kilometraje(kilometraje)
                    .cilindrada(cilindrada)
                    .tipoCamion(tipoCamion)
                    .capacidadToneladas(capacidadToneladas)
                    .cantidadEjes(cantidadEjes)
                    .build();
            return vehiculoRepository.findAllCamionesByParams(queryParams, pageable);
        } else {
            throw new RuntimeException("Tipo de vehículo no válido");
        }
    }

    public VehiculoDTO createVehiculo(VehiculoDTO vehiculo) {
        Vehiculo vehiculoEntity = vehiculoMapper.toEntity(vehiculo);

        Vehiculo saved = vehiculoRepository.saveAndFlush(vehiculoEntity);
        return vehiculoMapper.toDTO(saved);
    }

    public VehiculoDTO updateVehiculo(Long id, VehiculoDTO vehiculo) {
        Vehiculo existingVehiculo = getVehiculoById(id);
        if (existingVehiculo == null) {
            throw new RuntimeException("Vehículo no encontrado");
        }

        vehiculo.setId(existingVehiculo.getId());
        Vehiculo updatedVehiculo = vehiculoMapper.toEntity(vehiculo);
        updatedVehiculo.setId(existingVehiculo.getId());
        vehiculoRepository.save(updatedVehiculo);
        return vehiculoMapper.toDTO(updatedVehiculo);
    }


    public void deleteVehiculo(Long id) {
        Vehiculo vehiculo = getVehiculoById(id);
        if (vehiculo == null) {
            throw new RuntimeException("Vehículo no encontrado");
        }
        vehiculoRepository.delete(vehiculo);
    }

}
