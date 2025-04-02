package cl.myhotel.vehicles.resource;

import cl.myhotel.vehicles.dto.MantenimientoDTO;
import cl.myhotel.vehicles.service.MantenimientoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Resource for managing mantenimientos.
 *
 * @author Leonel Zeballos
 * @version 1.0
 */
@RestController
@RequestMapping("/api/v1/mantenimientos")
@RequiredArgsConstructor
@Slf4j
public class MantenimientoResource {

    /**
     * Service for managing mantenimientos.
     */
    private final MantenimientoService mantenimientoService;

    /**
     * Get a mantenimiento by id.
     *
     * @param id the id of the mantenimiento
     * @return the mantenimiento
     */
    @GetMapping("/{id}")
    public ResponseEntity<MantenimientoDTO> getMantenimientoById(@PathVariable Long id) {
        return ResponseEntity.ok(mantenimientoService.getMantenimientoById(id));
    }

    /**
     * Get a list of mantenimientos by vehiculoId.
     *
     * @param vehiculoId the id of the vehiculo
     * @return a list of mantenimientos
     */
    @GetMapping("/vehiculo/{vehiculoId}")
    public ResponseEntity<List<MantenimientoDTO>> getMantenimientoByVehiculoId(@PathVariable Long vehiculoId) {
        return ResponseEntity.ok(mantenimientoService.getMantenimientos(vehiculoId));
    }

    @PostMapping("/vehiculo/{vehiculoId}")
    public ResponseEntity<MantenimientoDTO> createMantenimiento(@PathVariable Long vehiculoId, @RequestBody MantenimientoDTO mantenimientoDTO) {
        return ResponseEntity.ok(mantenimientoService.createMantenimiento(vehiculoId, mantenimientoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MantenimientoDTO> updateMantenimiento(@PathVariable Long id, @RequestBody MantenimientoDTO mantenimientoDTO) {
        return ResponseEntity.ok(mantenimientoService.updateMantenimiento(id, mantenimientoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMantenimiento(@PathVariable Long id) {
        mantenimientoService.deleteMantenimiento(id);
        return ResponseEntity.noContent().build();
    }

}
