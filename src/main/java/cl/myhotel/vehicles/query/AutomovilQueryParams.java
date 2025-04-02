package cl.myhotel.vehicles.query;

import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * Query parameters for searching Automovil entities.
 * This class extends the VehiculoQueryParams class and adds specific attributes related to cars.
 * It includes the type of car, number of doors, passenger capacity, and trunk capacity.
 *
 * @author Leonel Zeballos
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class AutomovilQueryParams extends VehiculoQueryParams {

    private String tipoAuto;
    private Integer numPuertas;
    private Integer capacidadPasajeros;
    private Integer capacidadMaletero;

}
