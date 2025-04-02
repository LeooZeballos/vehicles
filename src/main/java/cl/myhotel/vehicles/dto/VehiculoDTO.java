package cl.myhotel.vehicles.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.*;

/**
 * Data Transfer Object (DTO) for vehicle information.
 * This class is used to transfer vehicle-related data between layers of the application.
 * It contains fields for the vehicle ID, brand, model, license plate,
 * year, mileage, engine displacement, and various vehicle types.
 *
 * @author Leonel Zeballos
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
public class VehiculoDTO {
    private Long id;
    private String marca;
    private String modelo;
    private String patente;
    private Integer anio;
    private Integer kilometraje;
    private Integer cilindrada;
    private String tipoVehiculo = ""; // vehiculo, automovil, camion
    private String tipoAuto; // automovil
    private String tipoCamion; // camion
    private Integer numPuertas; // automovil
    private Integer capacidadPasajeros; // automovil
    private Integer capacidadMaletero; // automovil
    private String capacidadToneladas; // camion
    private Integer cantidadEjes; // camion
}
