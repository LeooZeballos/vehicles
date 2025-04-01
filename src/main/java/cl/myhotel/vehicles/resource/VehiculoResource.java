package cl.myhotel.vehicles.resource;

import cl.myhotel.vehicles.model.Vehiculo;
import cl.myhotel.vehicles.service.VehiculoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Resource for managing vehiculos.
 *
 * @author Leonel Zeballos
 * @version 1.0
 */
@RestController
@RequestMapping("/api/v1/vehiculos")
@RequiredArgsConstructor
@Slf4j
public class VehiculoResource {

    /**
     * Service for managing vehiculos.
     */
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
