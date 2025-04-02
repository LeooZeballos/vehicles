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

/**
 * Service for managing vehicles.
 *
 * @author Leonel Zeballos
 */
@Service
@RequiredArgsConstructor
public class VehiculoService {

    /**
     * Repository for managing vehicle entities.
     */
    private final VehiculoRepository vehiculoRepository;

    /**
     * Mapper for converting between DTO and entity.
     */
    private final VehiculoMapper vehiculoMapper;

    /**
     * Gets a vehicle by its ID.
     *
     * @param id ID of the vehicle.
     * @return Vehicle entity.
     */
    public Vehiculo getVehiculoById(Long id) {
        return vehiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado"));
    }

    /**
     * Gets all vehicles based on the provided parameters.
     *
     * @param marca             Vehicle brand.
     * @param modelo            Vehicle model.
     * @param patente           Vehicle license plate.
     * @param anio              Vehicle year.
     * @param kilometraje       Vehicle mileage.
     * @param cilindrada        Vehicle engine displacement.
     * @param tipo              Vehicle type (ALL, AUTOMOVIL, CAMION).
     * @param tipoAuto          Type of automobile.
     * @param tipoCamion        Type of truck.
     * @param numPuertas        Number of doors.
     * @param capacidadPasajeros Passenger capacity.
     * @param capacidadMaletero  Trunk capacity.
     * @param capacidadToneladas Truck capacity in tons.
     * @param cantidadEjes      Number of axles.
     * @param pageable          Pagination information.
     * @return Page of vehicles matching the criteria.
     */
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

    /**
     * Creates a new vehicle.
     *
     * @param vehiculo DTO of the vehicle to create.
     * @return Created vehicle DTO.
     */
    public VehiculoDTO createVehiculo(VehiculoDTO vehiculo) {
        Vehiculo vehiculoEntity = vehiculoMapper.toEntity(vehiculo);

        Vehiculo saved = vehiculoRepository.saveAndFlush(vehiculoEntity);
        return vehiculoMapper.toDTO(saved);
    }

    /**
     * Updates an existing vehicle.
     *
     * @param id       ID of the vehicle to update.
     * @param vehiculo DTO of the vehicle to update.
     * @return Updated vehicle DTO.
     */
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

    /**
     * Deletes a vehicle by its ID.
     *
     * @param id ID of the vehicle to delete.
     */
    public void deleteVehiculo(Long id) {
        Vehiculo vehiculo = getVehiculoById(id);
        if (vehiculo == null) {
            throw new RuntimeException("Vehículo no encontrado");
        }
        vehiculoRepository.delete(vehiculo);
    }

}
