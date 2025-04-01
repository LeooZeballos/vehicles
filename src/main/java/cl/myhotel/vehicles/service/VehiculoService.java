package cl.myhotel.vehicles.service;

import cl.myhotel.vehicles.model.Vehiculo;
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

    public Vehiculo getVehiculoById(Long id) {
        return vehiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado"));
    }

    public Page<Vehiculo> getAllVehiculos(
            String marca,
            String modelo,
            String patente,
            Integer anio,
            Integer kilometraje,
            Integer cilindrada,
            String tipo,
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
            return null;
        } else if (tipo.equals("CAMION")) {
            return null;
        } else {
            throw new RuntimeException("Tipo de vehículo no válido");
        }
    }
}
