package cl.myhotel.vehicles.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Represents the different types of maintenance for vehicles.
 * This enum includes various maintenance types such as preventive, corrective, by hours, and by mileage.
 *
 * @author Leonel Zeballos
 */
public enum TipoMantenimiento {
    MANTENIMIENTO_PREVENTIVO("preventivo"),
    MANTENIMIENTO_CORRECTIVO("correctivo"),
    MANTENIMIENTO_POR_HORAS("por_horas"),
    MANTENIMIENTO_POR_KILOMETRAJE("por_kilometraje");

    /**
     * The name of the maintenance type.
     */
    private final String nombre;

    /**
     * Constructor for the TipoMantenimiento enum.
     *
     * @param nombre The name of the maintenance type.
     */
    TipoMantenimiento(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Gets the TipoMantenimiento enum value based on the provided name.
     *
     * @param tipoMantenimiento The name of the maintenance type.
     * @return The corresponding TipoMantenimiento enum value.
     * @throws IllegalArgumentException if the name does not match any TipoMantenimiento.
     */
    public static TipoMantenimiento getTipoByNombre(String tipoMantenimiento) {
        for (TipoMantenimiento tipo : TipoMantenimiento.values()) {
            if (tipo.nombre.equalsIgnoreCase(tipoMantenimiento)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de mantenimiento no válido: " + tipoMantenimiento);
    }

    /**
     * Gets the name of the maintenance type.
     *
     * @return The name of the maintenance type.
     */
    @JsonValue
    public String getNombre() {
        return nombre;
    }
}
