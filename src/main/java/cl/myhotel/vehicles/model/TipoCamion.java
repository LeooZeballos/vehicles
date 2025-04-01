package cl.myhotel.vehicles.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoCamion {

    TIPO_3_4("3/4"),
    TIPO_TOLVA("tolva"),
    TIPO_VOLQUETE("volquete"),
    TIPO_PLATAFORMA("plataforma"),
    TIPO_TANQUE("tanque"),
    TIPO_FRIGORIFICO("frigorifico");

    private final String nombre;

    TipoCamion(String nombre) {
        this.nombre = nombre;
    }

    public static TipoCamion getTipoByNombre(String tipoCamion) {
        for (TipoCamion tipo : TipoCamion.values()) {
            if (tipo.nombre.equalsIgnoreCase(tipoCamion)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de camión no válido: " + tipoCamion);
    }

    @JsonValue
    public String getNombre() {
        return nombre;
    }

}
