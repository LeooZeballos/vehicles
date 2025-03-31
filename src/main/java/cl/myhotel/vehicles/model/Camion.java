package cl.myhotel.vehicles.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
public class Camion extends Vehiculo {

    @Column(name = "tipo_camion")
    private TipoCamion tipoCamion;

    @Column(name = "capacidad_toneladas")
    private Double capacidadToneladas;

    @Column(name = "cantidad_ejes")
    private Integer cantidadEjes;

}
