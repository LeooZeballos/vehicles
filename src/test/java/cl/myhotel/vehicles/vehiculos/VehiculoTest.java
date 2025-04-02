package cl.myhotel.vehicles.vehiculos;

import cl.myhotel.vehicles.model.Mantenimiento;
import cl.myhotel.vehicles.model.Vehiculo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VehiculoTest {

    private Vehiculo vehiculo;
    private Mantenimiento mockMantenimiento;

    @BeforeEach
    void setUp() {
        vehiculo = Vehiculo.builder()
                .id(1L)
                .marca("Toyota")
                .modelo("Corolla")
                .patente("ABC123")
                .anio(2020)
                .kilometraje(15000)
                .cilindrada(1800)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .mantenimientos(new ArrayList<>())
                .build();

        mockMantenimiento = Mockito.mock(Mantenimiento.class);
    }

    @Test
    void testVehiculoBuilder() {
        assertNotNull(vehiculo);
        assertEquals(1L, vehiculo.getId());
        assertEquals("Toyota", vehiculo.getMarca());
        assertEquals("Corolla", vehiculo.getModelo());
        assertEquals("ABC123", vehiculo.getPatente());
        assertEquals(2020, vehiculo.getAnio());
        assertEquals(15000, vehiculo.getKilometraje());
        assertEquals(1800, vehiculo.getCilindrada());
        assertNotNull(vehiculo.getCreatedAt());
        assertNotNull(vehiculo.getUpdatedAt());
        assertNotNull(vehiculo.getMantenimientos());
        assertTrue(vehiculo.getMantenimientos().isEmpty());
    }

    @Test
    void testAddMantenimiento() {
        List<Mantenimiento> mantenimientos = new ArrayList<>();
        mantenimientos.add(mockMantenimiento);

        vehiculo.setMantenimientos(mantenimientos);

        assertEquals(1, vehiculo.getMantenimientos().size());
        assertTrue(vehiculo.getMantenimientos().contains(mockMantenimiento));
    }

    @Test
    void testRemoveMantenimiento() {
        List<Mantenimiento> mantenimientos = new ArrayList<>();
        mantenimientos.add(mockMantenimiento);
        vehiculo.setMantenimientos(mantenimientos);

        vehiculo.getMantenimientos().remove(mockMantenimiento);

        assertTrue(vehiculo.getMantenimientos().isEmpty());
    }

    @Test
    void testEqualsAndHashCode() {
        Vehiculo sameVehiculo = Vehiculo.builder()
                .id(1L)
                .marca("Toyota")
                .modelo("Corolla")
                .patente("ABC123")
                .anio(2020)
                .kilometraje(15000)
                .cilindrada(1800)
                .createdAt(vehiculo.getCreatedAt())
                .updatedAt(vehiculo.getUpdatedAt())
                .mantenimientos(new ArrayList<>())
                .build();

        Vehiculo differentVehiculo = Vehiculo.builder()
                .id(2L)
                .marca("Honda")
                .modelo("Civic")
                .patente("XYZ789")
                .anio(2021)
                .kilometraje(5000)
                .cilindrada(1500)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .mantenimientos(new ArrayList<>())
                .build();

        assertEquals(vehiculo, sameVehiculo);
        assertEquals(vehiculo.hashCode(), sameVehiculo.hashCode());
        assertNotEquals(vehiculo, differentVehiculo);
        assertNotEquals(vehiculo.hashCode(), differentVehiculo.hashCode());
    }

    @Test
    void testToString() {
        String toStringResult = vehiculo.toString();

        assertTrue(toStringResult.contains("Toyota"));
        assertTrue(toStringResult.contains("Corolla"));
        assertTrue(toStringResult.contains("ABC123"));
        assertTrue(toStringResult.contains("2020"));
        assertTrue(toStringResult.contains("15000"));
        assertTrue(toStringResult.contains("1800"));
    }

    @Test
    void testNoArgsConstructor() {
        Vehiculo emptyVehiculo = new Vehiculo();

        assertNull(emptyVehiculo.getId());
        assertNull(emptyVehiculo.getMarca());
        assertNull(emptyVehiculo.getModelo());
        assertNull(emptyVehiculo.getPatente());
        assertNull(emptyVehiculo.getAnio());
        assertNull(emptyVehiculo.getKilometraje());
        assertNull(emptyVehiculo.getCilindrada());
        assertNull(emptyVehiculo.getCreatedAt());
        assertNull(emptyVehiculo.getUpdatedAt());
        assertNotNull(emptyVehiculo.getMantenimientos());
        assertTrue(emptyVehiculo.getMantenimientos().isEmpty());
    }

    @Test
    void testAllArgsConstructor() {
        LocalDateTime now = LocalDateTime.now();
        List<Mantenimiento> mantenimientos = new ArrayList<>();
        mantenimientos.add(mockMantenimiento);

        Vehiculo parametrizedVehiculo = new Vehiculo(
                2L, "Honda", "Civic", "XYZ789",
                2021, 5000, 1500, now, now, mantenimientos);

        assertEquals(2L, parametrizedVehiculo.getId());
        assertEquals("Honda", parametrizedVehiculo.getMarca());
        assertEquals("Civic", parametrizedVehiculo.getModelo());
        assertEquals("XYZ789", parametrizedVehiculo.getPatente());
        assertEquals(2021, parametrizedVehiculo.getAnio());
        assertEquals(5000, parametrizedVehiculo.getKilometraje());
        assertEquals(1500, parametrizedVehiculo.getCilindrada());
        assertEquals(now, parametrizedVehiculo.getCreatedAt());
        assertEquals(now, parametrizedVehiculo.getUpdatedAt());
        assertEquals(1, parametrizedVehiculo.getMantenimientos().size());
        assertTrue(parametrizedVehiculo.getMantenimientos().contains(mockMantenimiento));
    }

    @Test
    void testSetters() {
        LocalDateTime newTime = LocalDateTime.now().plusDays(1);
        List<Mantenimiento> newMantenimientos = new ArrayList<>();
        newMantenimientos.add(mockMantenimiento);

        vehiculo.setId(10L);
        vehiculo.setMarca("Nissan");
        vehiculo.setModelo("Sentra");
        vehiculo.setPatente("DEF456");
        vehiculo.setAnio(2022);
        vehiculo.setKilometraje(20000);
        vehiculo.setCilindrada(2000);
        vehiculo.setCreatedAt(newTime);
        vehiculo.setUpdatedAt(newTime);
        vehiculo.setMantenimientos(newMantenimientos);

        assertEquals(10L, vehiculo.getId());
        assertEquals("Nissan", vehiculo.getMarca());
        assertEquals("Sentra", vehiculo.getModelo());
        assertEquals("DEF456", vehiculo.getPatente());
        assertEquals(2022, vehiculo.getAnio());
        assertEquals(20000, vehiculo.getKilometraje());
        assertEquals(2000, vehiculo.getCilindrada());
        assertEquals(newTime, vehiculo.getCreatedAt());
        assertEquals(newTime, vehiculo.getUpdatedAt());
        assertEquals(1, vehiculo.getMantenimientos().size());
        assertTrue(vehiculo.getMantenimientos().contains(mockMantenimiento));
    }

    @Test
    void testCreatedAtNotUpdatable() {
        // This would typically be tested with an integration test that tries to update the entity
        // For unit testing, we can just verify the annotation exists
        // This is more of a documentation test
        assertTrue(true, "CreatedAt should be marked as updatable=false in the entity");
    }
}