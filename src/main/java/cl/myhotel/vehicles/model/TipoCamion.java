package cl.myhotel.vehicles.model;

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

}
