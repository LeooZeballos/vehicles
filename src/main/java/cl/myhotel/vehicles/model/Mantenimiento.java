package cl.myhotel.vehicles.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

/**
 * Represents a maintenance record for a vehicle.
 * This class contains information about the type of maintenance performed,
 * the vehicle associated with the maintenance, and any observations related to the maintenance.
 * It also includes timestamps for when the record was created and last updated.
 *
 * @author Leonel Zeballos
 */
@Entity
@Table(name = "mantenimiento")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public class Mantenimiento {

    /**
     * The unique identifier for the maintenance record.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "mantenimiento_seq", sequenceName = "mantenimiento_seq", allocationSize = 1)
    private Long id;

    /**
     * The type of maintenance performed.
     */
    @Column(name = "tipo_mantenimiento")
    private TipoMantenimiento tipoMantenimiento;

    /**
     * The date when the maintenance was performed.
     */
    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    /**
     * The date when the maintenance record was last updated.
     */
    @Column(name = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    /**
     * The vehicle associated with the maintenance record.
     */
    @ManyToOne
    @JoinColumn(name = "vehiculo_id", nullable = false)
    private Vehiculo vehiculo;

    /**
     * The observations related to the maintenance.
     */
    @Column(name = "observaciones")
    private String observaciones;

}
