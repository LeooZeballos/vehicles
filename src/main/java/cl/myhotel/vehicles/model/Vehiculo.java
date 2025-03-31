package cl.myhotel.vehicles.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "vehiculo")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public class Vehiculo {

    @Id
    private Integer id;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "patente")
    private String patente;

    @Column(name = "anio")
    private Integer anio;

    @Column(name = "kilometraje")
    private Integer kilometraje;

    @Column(name = "cilindrada")
    private Integer cilindrada;

    @Column(name = "tipo")
    private String tipo;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;

}
