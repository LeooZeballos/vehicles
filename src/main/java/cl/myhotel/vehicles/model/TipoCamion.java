package cl.myhotel.vehicles.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Represents the different types of trucks.
 * This enum includes various truck types such as 3/4, tolva, volquete, etc.
 *
 * @author Leonel Zeballos
 */
public enum TipoCamion {

    TIPO_3_4("3/4"),
    TIPO_TOLVA("tolva"),
    TIPO_VOLQUETE("volquete"),
    TIPO_PLATAFORMA("plataforma"),
    TIPO_TANQUE("tanque"),
    TIPO_FRIGORIFICO("frigorifico");

    /**
     * The name of the truck type.
     */
    private final String nombre;

    /**
     * Constructor for the TipoCamion enum.
     *
     * @param nombre The name of the truck type.
     */
    TipoCamion(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Gets the TipoCamion enum value based on the provided name.
     *
     * @param tipoCamion The name of the truck type.
     * @return The corresponding TipoCamion enum value.
     * @throws IllegalArgumentException if the name does not match any TipoCamion.
     */
    public static TipoCamion getTipoByNombre(String tipoCamion) {
        for (TipoCamion tipo : TipoCamion.values()) {
            if (tipo.nombre.equalsIgnoreCase(tipoCamion)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de camión no válido: " + tipoCamion);
    }

    /**
     * Gets the name of the truck type.
     *
     * @return The name of the truck type.
     */
    @JsonValue
    public String getNombre() {
        return nombre;
    }

}
