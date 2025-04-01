package cl.myhotel.vehicles.resource;

import cl.myhotel.vehicles.model.Vehiculo;
import cl.myhotel.vehicles.service.VehiculoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Page<Vehiculo>> getAllVehiculos(
            @RequestParam(required = false) String marca,
            @RequestParam(required = false) String modelo,
            @RequestParam(required = false) String patente,
            @RequestParam(required = false) Integer anio,
            @RequestParam(required = false) Integer kilometraje,
            @RequestParam(required = false) Integer cilindrada,
            @RequestParam(required = false) String tipo,
            Pageable pageable
    ) {
        return ResponseEntity.ok(vehiculoService.getAllVehiculos(
                marca, modelo, patente, anio, kilometraje, cilindrada, tipo, pageable));
    }

}
