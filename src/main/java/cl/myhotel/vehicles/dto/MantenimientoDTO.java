package cl.myhotel.vehicles.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Data Transfer Object (DTO) for vehicle maintenance information.
 * This class is used to transfer maintenance-related data between layers of the application.
 * It contains fields for the maintenance ID, type, creation and update timestamps,
 * associated vehicle, and any observations related to the maintenance.
 *
 * @author Leonel Zeballos
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MantenimientoDTO {
    private Long id;
    private String tipoMantenimiento;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private VehiculoDTO vehiculo;
    private String observaciones;
}
