package cl.myhotel.vehicles.query;

import lombok.*;
import lombok.experimental.SuperBuilder;

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
