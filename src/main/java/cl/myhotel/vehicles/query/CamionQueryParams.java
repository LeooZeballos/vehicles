package cl.myhotel.vehicles.query;

import lombok.*;
import lombok.experimental.SuperBuilder;

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
