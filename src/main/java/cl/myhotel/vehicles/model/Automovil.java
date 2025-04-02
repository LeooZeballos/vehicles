package cl.myhotel.vehicles.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.annotations.Comment;

/**
 * Represents a car entity in the system.
 * This class extends the Vehiculo class and adds specific attributes related to cars.
 * It includes the type of car, number of doors, passenger capacity, and trunk capacity.
 *
 * @author Leonel Zeballos
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
public class Automovil extends Vehiculo {

    /**
     * The type of car.
     */
    @Column(name = "tipo_auto")
    private TipoAutomovil tipoAuto;

    /**
     * The number of doors in the car.
     */
    @Column(name = "num_puertas")
    private Integer numPuertas;

    /**
     * The passenger capacity of the car.
     */
    @Column(name = "capacidad_pasajeros")
    private Integer capacidadPasajeros;

    /**
     * The trunk capacity of the car in liters.
     */
    @Column(name = "capacidad_maletero")
    @Comment("Capacidad del maletero en litros")
    private Integer capacidadMaletero;

}
