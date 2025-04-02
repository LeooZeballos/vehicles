package cl.myhotel.vehicles.vehiculos;

import cl.myhotel.vehicles.dto.VehiculoDTO;
import cl.myhotel.vehicles.mapper.VehiculoMapper;
import cl.myhotel.vehicles.model.*;
import cl.myhotel.vehicles.query.AutomovilQueryParams;
import cl.myhotel.vehicles.query.CamionQueryParams;
import cl.myhotel.vehicles.query.VehiculoQueryParams;
import cl.myhotel.vehicles.repository.VehiculoRepository;
import cl.myhotel.vehicles.service.VehiculoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

@SpringBootTest
@AutoConfigureMockMvc
public class VehiculoServiceTest {

    private VehiculoService vehiculoService;

    @Mock
    private VehiculoRepository vehiculoRepository;

    @Mock
    private VehiculoMapper vehiculoMapper;

    @BeforeEach
    void setUp() {
        try (AutoCloseable ignored = openMocks(this)) {
            vehiculoService = new VehiculoService(vehiculoRepository, vehiculoMapper);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void shouldReturnListOfVehicles() {
        // Create test data
        List<Vehiculo> vehiculos = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        vehiculos.add(new Vehiculo(1L, "Toyota", "Corolla", "ABC123", 2020, 15000, 2000, now, now, List.of()));
        vehiculos.add(new Vehiculo(2L, "Honda", "Civic", "XYZ789", 2021, 12000, 1800, now, now, List.of()));
        vehiculos.add(new Vehiculo(3L, "Ford", "Focus", "LMN456", 2019, 20000, 2200, now, now, List.of()));
        vehiculos.add(new Vehiculo(4L, "Chevrolet", "Cruze", "DEF123", 2022, 8000, 1600, now, now, List.of()));
        vehiculos.add(new Vehiculo(5L, "Nissan", "Altima", "GHI789", 2023, 5000, 1700, now, now, List.of()));

        VehiculoQueryParams queryParams = VehiculoQueryParams.builder()
                .marca(null).modelo(null).patente(null).anio(null)
                .kilometraje(null).cilindrada(null).build();

        @SuppressWarnings("unchecked") Page<Vehiculo> page = mock(Page.class);
        when(page.getContent()).thenReturn(vehiculos);
        when(page.getPageable()).thenReturn(Pageable.unpaged());

        when(vehiculoRepository.findAllByParams(queryParams, Pageable.unpaged())).thenReturn(page);

        // Perform the test
        @SuppressWarnings("unchecked") Page<Vehiculo> response = (Page<Vehiculo>) vehiculoService.getAllVehiculos(
                null, null, null, null, null, null, null,
                null, null, null, null, null, null, null,
                Pageable.unpaged()
        );

        // Verify the response
        assertNotNull(response);
        assertNotNull(response.getContent());
        assertEquals(5, response.getContent().size());
        assertEquals(1L, response.getContent().get(0).getId());
        assertEquals("Toyota", response.getContent().get(0).getMarca());
        assertEquals("Corolla", response.getContent().get(0).getModelo());
        assertEquals("ABC123", response.getContent().get(0).getPatente());
        assertEquals(2020, response.getContent().get(0).getAnio());
        assertEquals(15000, response.getContent().get(0).getKilometraje());
        assertEquals(2000, response.getContent().get(0).getCilindrada());
        assertEquals(now, response.getContent().get(0).getCreatedAt());
        assertEquals(now, response.getContent().get(0).getUpdatedAt());

        verify(vehiculoRepository).findAllByParams(queryParams, Pageable.unpaged());
    }

    @Test
    void shouldReutrnListOfAutomoviles() {
        // Create test data
        List<Automovil> automoviles = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        automoviles.add(Automovil.builder().id(1L).marca("Toyota").modelo("Corolla").patente("ABC123").anio(2022).kilometraje(15000).cilindrada(1800).createdAt(now).updatedAt(now).mantenimientos(new ArrayList<>()).tipoAuto(TipoAutomovil.TIPO_SEDAN).numPuertas(4).capacidadPasajeros(5).capacidadMaletero(420).build());
        automoviles.add(Automovil.builder().id(2L).marca("Honda").modelo("Civic").patente("XYZ789").anio(2021).kilometraje(12000).cilindrada(1600).createdAt(now).updatedAt(now).mantenimientos(new ArrayList<>()).tipoAuto(TipoAutomovil.TIPO_HATCHBACK).numPuertas(5).capacidadPasajeros(5).capacidadMaletero(400).build());
        automoviles.add(Automovil.builder().id(3L).marca("Ford").modelo("Focus").patente("LMN456").anio(2019).kilometraje(20000).cilindrada(2000).createdAt(now).updatedAt(now).mantenimientos(new ArrayList<>()).tipoAuto(TipoAutomovil.TIPO_SUV).numPuertas(5).capacidadPasajeros(5).capacidadMaletero(500).build());
        automoviles.add(Automovil.builder().id(4L).marca("Chevrolet").modelo("Cruze").patente("DEF123").anio(2022).kilometraje(8000).cilindrada(1500).createdAt(now).updatedAt(now).mantenimientos(new ArrayList<>()).tipoAuto(TipoAutomovil.TIPO_SEDAN).numPuertas(4).capacidadPasajeros(5).capacidadMaletero(450).build());
        automoviles.add(Automovil.builder().id(5L).marca("Nissan").modelo("Altima").patente("GHI789").anio(2023).kilometraje(5000).cilindrada(1700).createdAt(now).updatedAt(now).mantenimientos(new ArrayList<>()).tipoAuto(TipoAutomovil.TIPO_SEDAN).numPuertas(4).capacidadPasajeros(5).capacidadMaletero(480).build());
        AutomovilQueryParams queryParams = AutomovilQueryParams.builder()
                .marca(null).modelo(null).patente(null).anio(null)
                .kilometraje(null).cilindrada(null).build();
        @SuppressWarnings("unchecked") Page<Automovil> page = mock(Page.class);
        when(page.getContent()).thenReturn(automoviles);
        when(page.getPageable()).thenReturn(Pageable.unpaged());
        when(vehiculoRepository.findAllAutomovilesByParams(queryParams, Pageable.unpaged())).thenReturn(page);

        // Perform the test
        @SuppressWarnings("unchecked") Page<Automovil> response = (Page<Automovil>) vehiculoService.getAllVehiculos(
                null, null, null, null, null, null, "AUTOMOVIL",
                null, null, null, null, null, null, null,
                Pageable.unpaged()
        );

        // Verify the response
        assertNotNull(response);
        assertNotNull(response.getContent());
        assertEquals(5, response.getContent().size());
        assertEquals(1L, response.getContent().get(0).getId());
        assertEquals("Toyota", response.getContent().get(0).getMarca());
        assertEquals("Corolla", response.getContent().get(0).getModelo());
        assertEquals("ABC123", response.getContent().get(0).getPatente());
        assertEquals(2022, response.getContent().get(0).getAnio());
        assertEquals(15000, response.getContent().get(0).getKilometraje());
        assertEquals(1800, response.getContent().get(0).getCilindrada());
        assertEquals(now, response.getContent().get(0).getCreatedAt());
        assertEquals(now, response.getContent().get(0).getUpdatedAt());
        assertEquals(TipoAutomovil.TIPO_SEDAN, response.getContent().get(0).getTipoAuto());
        assertEquals(4, response.getContent().get(0).getNumPuertas());
        assertEquals(5, response.getContent().get(0).getCapacidadPasajeros());
        assertEquals(420, response.getContent().get(0).getCapacidadMaletero());

        verify(vehiculoRepository).findAllAutomovilesByParams(queryParams, Pageable.unpaged());
    }

    @Test
    void shouldReutrnListOfCamiones() {
        // Create test data
        List<Camion> camiones = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        camiones.add(Camion.builder().id(1L).marca("Volvo").modelo("FH16").patente("ABC123").anio(2022).kilometraje(15000).cilindrada(1800).createdAt(now).updatedAt(now).mantenimientos(new ArrayList<>()).tipoCamion(TipoCamion.TIPO_3_4).capacidadToneladas(4.0).cantidadEjes(20000).build());
        camiones.add(Camion.builder().id(2L).marca("Scania").modelo("R 500").patente("XYZ789").anio(2021).kilometraje(12000).cilindrada(1600).createdAt(now).updatedAt(now).mantenimientos(new ArrayList<>()).tipoCamion(TipoCamion.TIPO_FRIGORIFICO).capacidadToneladas(10.0).cantidadEjes(20000).build());
        camiones.add(Camion.builder().id(3L).marca("Mercedes-Benz").modelo("Actros").patente("LMN456").anio(2019).kilometraje(20000).cilindrada(2000).createdAt(now).updatedAt(now).mantenimientos(new ArrayList<>()).tipoCamion(TipoCamion.TIPO_3_4).capacidadToneladas(8.0).cantidadEjes(20000).build());
        camiones.add(Camion.builder().id(4L).marca("MAN").modelo("TGX").patente("DEF123").anio(2020).kilometraje(10000).cilindrada(2200).createdAt(now).updatedAt(now).mantenimientos(new ArrayList<>()).tipoCamion(TipoCamion.TIPO_TANQUE).capacidadToneladas(12.0).cantidadEjes(20000).build());

        CamionQueryParams queryParams = CamionQueryParams.builder()
                .marca(null).modelo(null).patente(null).anio(null)
                .kilometraje(null).cilindrada(null).build();

        @SuppressWarnings("unchecked") Page<Camion> page = mock(Page.class);
        when(page.getContent()).thenReturn(camiones);
        when(page.getPageable()).thenReturn(Pageable.unpaged());
        when(vehiculoRepository.findAllCamionesByParams(queryParams, Pageable.unpaged())).thenReturn(page);

        // Perform the test
        @SuppressWarnings("unchecked") Page<Camion> response = (Page<Camion>) vehiculoService.getAllVehiculos(
                null, null, null, null, null, null, "CAMION",
                null, null, null, null, null, null, null,
                Pageable.unpaged()
        );

        // Verify the response
        assertNotNull(response);
        assertNotNull(response.getContent());
        assertEquals(4, response.getContent().size());
        assertEquals(1L, response.getContent().get(0).getId());
        assertEquals("Volvo", response.getContent().get(0).getMarca());
        assertEquals("FH16", response.getContent().get(0).getModelo());
        assertEquals("ABC123", response.getContent().get(0).getPatente());
        assertEquals(2022, response.getContent().get(0).getAnio());
        assertEquals(15000, response.getContent().get(0).getKilometraje());
        assertEquals(1800, response.getContent().get(0).getCilindrada());
        assertEquals(now, response.getContent().get(0).getCreatedAt());
        assertEquals(now, response.getContent().get(0).getUpdatedAt());
        assertEquals(TipoCamion.TIPO_3_4, response.getContent().get(0).getTipoCamion());
        assertEquals(4.0, response.getContent().get(0).getCapacidadToneladas());
        assertEquals(20000, response.getContent().get(0).getCantidadEjes());

        verify(vehiculoRepository).findAllCamionesByParams(queryParams, Pageable.unpaged());
    }

    @Test
    void shouldCreateNewVehiculo() {
        // Create test data
        LocalDateTime now = LocalDateTime.now();
        VehiculoDTO vehiculo = VehiculoDTO.builder()
                .marca("Toyota")
                .modelo("Corolla")
                .patente("ABC123")
                .anio(2020)
                .kilometraje(15000)
                .cilindrada(2000)
                .createdAt(now)
                .updatedAt(now)
                .build();
        Vehiculo vehiculoEntity = new Vehiculo(1L, "Toyota", "Corolla", "ABC123", 2020, 15000, 2000, now, now, List.of());

        when(vehiculoMapper.toEntity(vehiculo)).thenReturn(vehiculoEntity);
        when(vehiculoRepository.saveAndFlush(vehiculoEntity)).thenReturn(vehiculoEntity);
        when(vehiculoMapper.toDTO(vehiculoEntity)).thenReturn(vehiculo);

        // Perform the test
        VehiculoDTO response = vehiculoService.createVehiculo(vehiculo);

        // Verify the response
        assertNotNull(response);
        assertEquals("Toyota", response.getMarca());
        assertEquals("Corolla", response.getModelo());
        assertEquals("ABC123", response.getPatente());
        assertEquals(2020, response.getAnio());
        assertEquals(15000, response.getKilometraje());
        assertEquals(2000, response.getCilindrada());
        assertEquals(now, response.getCreatedAt());
        assertEquals(now, response.getUpdatedAt());

        verify(vehiculoMapper).toEntity(vehiculo);
        verify(vehiculoRepository).saveAndFlush(vehiculoEntity);
        verify(vehiculoMapper).toDTO(vehiculoEntity);
    }

    @Test
    void shouldUpdateVehiculo() {
        // Create test data
        LocalDateTime now = LocalDateTime.now();
        Long vehiculoId = 1L;
        VehiculoDTO vehiculoDTO = VehiculoDTO.builder()
                .id(vehiculoId)
                .marca("Toyota")
                .modelo("Corolla")
                .patente("ABC123")
                .anio(2020)
                .kilometraje(15000)
                .cilindrada(2000)
                .createdAt(now)
                .updatedAt(now)
                .build();
        Vehiculo existingVehiculo = new Vehiculo(vehiculoId, "Toyota", "Corolla", "ABC123", 2020, 15000, 2000, now, now, List.of());
        Vehiculo updatedVehiculoEntity = new Vehiculo(vehiculoId, "Toyota", "Corolla", "ABC123", 2020, 15000, 2000, now, now, List.of());

        when(vehiculoRepository.findById(vehiculoId)).thenReturn(java.util.Optional.of(existingVehiculo));
        when(vehiculoMapper.toEntity(vehiculoDTO)).thenReturn(updatedVehiculoEntity);
        when(vehiculoRepository.save(updatedVehiculoEntity)).thenReturn(updatedVehiculoEntity);
        when(vehiculoMapper.toDTO(updatedVehiculoEntity)).thenReturn(vehiculoDTO);

        // Perform the test
        VehiculoDTO response = vehiculoService.updateVehiculo(vehiculoId, vehiculoDTO);

        // Verify the response
        assertNotNull(response);
        assertEquals("Toyota", response.getMarca());
        assertEquals("Corolla", response.getModelo());
        assertEquals("ABC123", response.getPatente());
        assertEquals(2020, response.getAnio());
        assertEquals(15000, response.getKilometraje());
        assertEquals(2000, response.getCilindrada());
        assertEquals(now, response.getCreatedAt());
        assertEquals(now, response.getUpdatedAt());

        verify(vehiculoRepository).findById(vehiculoId);
        verify(vehiculoMapper).toEntity(vehiculoDTO);
        verify(vehiculoRepository).save(updatedVehiculoEntity);
    }

    @Test
    void shouldDeleteVehiculo() {
        // Create test data
        Long vehiculoId = 1L;
        LocalDateTime now = LocalDateTime.now();
        Vehiculo vehiculo = new Vehiculo(vehiculoId, "Toyota", "Corolla", "ABC123", 2020, 15000, 2000, now, now, List.of());

        when(vehiculoRepository.findById(vehiculoId)).thenReturn(java.util.Optional.of(vehiculo));

        // Perform the test
        vehiculoService.deleteVehiculo(vehiculoId);

        // Verify the response
        verify(vehiculoRepository).findById(vehiculoId);
        verify(vehiculoRepository).delete(vehiculo);
    }

}
