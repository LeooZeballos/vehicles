package cl.myhotel.vehicles.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a vehicle entity in the system.
 * This class contains common attributes for all types of vehicles,
 * such as brand, model, license plate, year, mileage, and engine displacement.
 * It also includes timestamps for when the vehicle was created and last updated,
 * as well as a list of maintenance records associated with the vehicle.
 *
 * @author Leonel Zeballos
 */
@Entity
@Table(name = "vehiculo")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public class Vehiculo {

    /**
     * The unique identifier for the vehicle.
     * It is generated automatically by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "vehiculo_seq", sequenceName = "vehiculo_seq", allocationSize = 1)
    private Long id;

    /**
     * The brand of the vehicle.
     */
    @Column(name = "marca")
    private String marca;

    /**
     * The model of the vehicle.
     */
    @Column(name = "modelo")
    private String modelo;

    /**
     * The license plate of the vehicle.
     */
    @Column(name = "patente")
    private String patente;

    /**
     * The year of manufacture of the vehicle.
     */
    @Column(name = "anio")
    private Integer anio;

    /**
     * The type of vehicle.
     */
    @Column(name = "kilometraje")
    private Integer kilometraje;

    /**
     * The engine displacement of the vehicle in cc.
     */
    @Column(name = "cilindrada")
    private Integer cilindrada;

    /**
     * The date when the vehicle was created.
     * It is automatically set when the vehicle is created.
     */
    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    /**
     * The date when the vehicle was last updated.
     * It is automatically set when the vehicle is updated.
     */
    @Column(name = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    /**
     * The list of maintenance records associated with the vehicle.
     * It is a one-to-many relationship with the Mantenimiento class.
     */
    @OneToMany
    private List<Mantenimiento> mantenimientos = new ArrayList<>();

}
