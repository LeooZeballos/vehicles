package cl.myhotel.vehicles.repository;

import cl.myhotel.vehicles.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for managing user entities.
 * This repository extends {@link JpaRepository} to provide CRUD operations.
 *
 * @see JpaRepository
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Find a user by username.
     *
     * @param username the username of the user
     * @return an Optional containing the user if found, or empty if not found
     */
    Optional<User> findByUsername(String username);

    /**
     * Find a user by email.
     *
     * @param username the email of the user
     * @return an Optional containing the user if found, or empty if not found
     */
    boolean existsByUsername(String username);

    /**
     * Check if a user exists by email.
     *
     * @param email the email of the user
     * @return true if the user exists, false otherwise
     */
    boolean existsByEmail(String email);

}