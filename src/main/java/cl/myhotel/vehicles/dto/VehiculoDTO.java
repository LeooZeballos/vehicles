package cl.myhotel.vehicles.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
public class VehiculoDTO {
    private Integer id;
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
