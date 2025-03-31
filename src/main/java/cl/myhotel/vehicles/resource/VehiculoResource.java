package cl.myhotel.vehicles.resource;


import cl.myhotel.vehicles.model.Vehiculo;
import cl.myhotel.vehicles.service.VehiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/v1/vehiculos")
@RequiredArgsConstructor
public class VehiculoResource {

    private final VehiculoService vehiculoService;

    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> getVehiculoById(@PathVariable Long id) {
        return ResponseEntity.ok(vehiculoService.getVehiculoById(id));
    }

    @GetMapping
    public ResponseEntity<List<Vehiculo>> getAllVehiculos() {
        return ResponseEntity.ok(vehiculoService.getAllVehiculos());
    }

}
