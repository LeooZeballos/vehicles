package cl.myhotel.vehicles.repository;

import cl.myhotel.vehicles.model.Vehiculo;
import cl.myhotel.vehicles.query.VehiculoQueryParams;
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
            return builder.and(predicates.toArray(new Predicate[0]));
        }, pageable);
    }
}
