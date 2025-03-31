package cl.myhotel.vehicles.service;

import cl.myhotel.vehicles.model.Vehiculo;
import cl.myhotel.vehicles.repository.VehiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    public Vehiculo getVehiculoById(Long id) {
        return vehiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado"));
    }

    public List<Vehiculo> getAllVehiculos() {
        return vehiculoRepository.findAll();
    }
}
