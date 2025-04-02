package cl.myhotel.vehicles.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

/**
 * Represents a truck entity in the system.
 * This class extends the Vehiculo class and adds specific attributes related to trucks.
 * It includes the type of truck, load capacity in tons, and the number of axles.
 *
 * @author Leonel Zeballos
 */
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
