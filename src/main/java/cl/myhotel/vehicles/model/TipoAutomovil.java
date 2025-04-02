package cl.myhotel.vehicles.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Represents the different types of automobiles.
 * This enum includes various car types such as Hatchback, Sedan, Coupe, etc.
 *
 * @author Leonel Zeballos
 */
public enum TipoAutomovil {

    TIPO_HATCHBACK("Hatchback"),
    TIPO_SEDAN("Sedan"),
    TIPO_CUPE("Coupé"),
    TIPO_CONVERTIBLE("Convertible"),
    TIPO_VAN("Van"),
    TIPO_PICKUP("Pickup"),
    TIPO_SUV("SUV"),
    TIPO_CROSSOVER("Crossover"),
    TIPO_MINIVAN("Minivan"),
    TIPO_WAGON("Wagon"),
    TIPO_CABRIOLET("Cabriolet");

    /**
     * The name of the car type.
     */
    private final String nombre;

    /**
     * Constructor for the TipoAutomovil enum.
     *
     * @param nombre The name of the car type.
     */
    TipoAutomovil(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Gets the TipoAutomovil enum value based on the provided name.
     *
     * @param nombre The name of the car type.
     * @return The corresponding TipoAutomovil enum value.
     * @throws IllegalArgumentException if the name does not match any TipoAutomovil.
     */
    public static TipoAutomovil getTipoByNombre(String nombre) {
        for (TipoAutomovil tipo : TipoAutomovil.values()) {
            if (tipo.nombre.equalsIgnoreCase(nombre)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de automóvil no válido: " + nombre);
    }

    /**
     * Gets the name of the car type.
     *
     * @return The name of the car type.
     */
    @JsonValue
    public String getNombre() {
        return nombre;
    }

}
