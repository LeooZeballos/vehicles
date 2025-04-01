package cl.myhotel.vehicles.model;

import com.fasterxml.jackson.annotation.JsonValue;

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

    private final String nombre;

    TipoAutomovil(String nombre) {
        this.nombre = nombre;
    }

    public static TipoAutomovil getTipoByNombre(String nombre) {
        for (TipoAutomovil tipo : TipoAutomovil.values()) {
            if (tipo.nombre.equalsIgnoreCase(nombre)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de automóvil no válido: " + nombre);
    }

    @JsonValue
    public String getNombre() {
        return nombre;
    }

}
