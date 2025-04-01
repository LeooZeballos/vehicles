package cl.myhotel.vehicles.model;

public enum TipoAutomovil {

    TIPO_HATCHBACK("Hatchback"),
    TIPO_SEDAN("Sedan"),
    TIPO_CUPÉ("Coupé"),
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

}
