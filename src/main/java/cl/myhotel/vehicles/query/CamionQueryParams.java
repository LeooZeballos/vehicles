package cl.myhotel.vehicles.query;

import lombok.*;
import lombok.experimental.SuperBuilder;


/**
 * Query parameters for searching Camion entities.
 * This class extends the VehiculoQueryParams class and adds specific attributes related to trucks.
 * It includes the type of truck, load capacity in tons, and the number of axles.
 *
 * @author Leonel Zeballos
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CamionQueryParams extends VehiculoQueryParams {

    private String tipoCamion;
    private Double capacidadToneladas;
    private Integer cantidadEjes;

}
