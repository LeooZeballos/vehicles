package cl.myhotel.vehicles.repository;

import cl.myhotel.vehicles.model.*;
import cl.myhotel.vehicles.query.AutomovilQueryParams;
import cl.myhotel.vehicles.query.CamionQueryParams;
import cl.myhotel.vehicles.query.VehiculoQueryParams;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.criteria.Predicate;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long>, JpaSpecificationExecutor<Vehiculo> {
    default Page<Vehiculo> findAllByParams(VehiculoQueryParams queryParams, Pageable pageable) {
        return findAll((root, query, builder) -> {
            List<Predicate> predicates = getVehiculoPredicates(queryParams, root, builder);
            return builder.and(predicates.toArray(new Predicate[0]));
        }, pageable);
    }

    public static List<Predicate> getVehiculoPredicates(VehiculoQueryParams queryParams, Root<Vehiculo> root, CriteriaBuilder builder) {
        List<Predicate> predicates = new ArrayList<>();
        if (queryParams.getId() != null) {
            predicates.add(root.get("id").in(queryParams.getId()));
        }
        if (queryParams.getMarca() != null) {
            predicates.add(builder.like(root.get("marca"), "%" + queryParams.getMarca() + "%"));
        }
        if (queryParams.getModelo() != null) {
            predicates.add(builder.like(root.get("modelo"), "%" + queryParams.getModelo() + "%"));
        }
        if (queryParams.getPatente() != null) {
            predicates.add(builder.like(root.get("patente"), "%" + queryParams.getPatente() + "%"));
        }
        if (queryParams.getAnio() != null) {
            predicates.add(builder.equal(root.get("anio"), queryParams.getAnio()));
        }
        if (queryParams.getKilometraje() != null) {
            predicates.add(builder.equal(root.get("kilometraje"), queryParams.getKilometraje()));
        }
        if (queryParams.getCilindrada() != null) {
            predicates.add(builder.equal(root.get("cilindrada"), queryParams.getCilindrada()));
        }
        if (queryParams.getCreatedAt() != null) {
            predicates.add(builder.greaterThanOrEqualTo(root.get("createdAt"), queryParams.getCreatedAt()));
        }
        if (queryParams.getUpdatedAt() != null) {
            predicates.add(builder.lessThanOrEqualTo(root.get("updatedAt"), queryParams.getUpdatedAt()));
        }
        return predicates;
    }

    default Page<Automovil> findAllAutomovilesByParams(AutomovilQueryParams queryParams, Pageable pageable) {
        return findAll((root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Filter for Automovil type
            predicates.add(builder.equal(root.type(), builder.literal(Automovil.class)));

            // Add vehicle predicates
            predicates.addAll(getVehiculoPredicates(queryParams, root, builder));

            // Add Automovil specific predicates
            if (queryParams.getTipoAuto() != null) {
                predicates.add(builder.equal(root.get("tipoAuto"), TipoAutomovil.getTipoByNombre(queryParams.getTipoAuto())));
            }
            if (queryParams.getNumPuertas() != null) {
                predicates.add(builder.equal(root.get("numPuertas"), queryParams.getNumPuertas()));
            }
            if (queryParams.getCapacidadPasajeros() != null) {
                predicates.add(builder.equal(root.get("capacidadPasajeros"), queryParams.getCapacidadPasajeros()));
            }
            if (queryParams.getCapacidadMaletero() != null) {
                predicates.add(builder.equal(root.get("capacidadMaletero"), queryParams.getCapacidadMaletero()));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        }, pageable).map(entity -> (Automovil) entity);
    }

    default Page<Camion> findAllCamionesByParams(CamionQueryParams queryParams, Pageable pageable) {
        return findAll((root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Filter for Camion type
            predicates.add(builder.equal(root.type(), builder.literal(Camion.class)));

            // Add vehicle predicates
            predicates.addAll(getVehiculoPredicates(queryParams, root, builder));

            // Add Camion specific predicates
            if (queryParams.getTipoCamion() != null) {
                predicates.add(builder.equal(root.get("tipoCamion"), TipoCamion.getTipoByNombre(queryParams.getTipoCamion())));
            }
            if (queryParams.getCapacidadToneladas() != null) {
                predicates.add(builder.equal(root.get("capacidadToneladas"), queryParams.getCapacidadToneladas()));
            }
            if (queryParams.getCantidadEjes() != null) {
                predicates.add(builder.equal(root.get("cantidadEjes"), queryParams.getCantidadEjes()));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        }, pageable).map(entity -> (Camion) entity);
    }

}
