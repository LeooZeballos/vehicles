package cl.myhotel.vehicles.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

/**
 * Query parameters for searching Vehiculo entities.
 * This class includes common attributes for all vehicle types.
 * It includes the vehicle ID, brand, model, license plate, year, mileage, and engine displacement.
 *
 * @author Leonel Zeballos
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoQueryParams {
    private Long id;
    private String marca;
    private String modelo;
    private String patente;
    private Integer anio;
    private Integer kilometraje;
    private Integer cilindrada;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
