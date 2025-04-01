package cl.myhotel.vehicles.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.annotations.Comment;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
public class Automovil extends Vehiculo {

    @Column(name = "tipo_auto")
    private TipoAutomovil tipoAuto;

    @Column(name = "num_puertas")
    private Integer numPuertas;

    @Column(name = "capacidad_pasajeros")
    private Integer capacidadPasajeros;

    @Column(name = "capacidad_maletero")
    @Comment("Capacidad del maletero en litros")
    private Integer capacidadMaletero;

}
