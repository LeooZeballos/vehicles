package cl.myhotel.vehicles.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The user entity.
 * It implements {@link UserDetails} to be used by Spring Security.
 *
 * @see UserDetails
 * @author Leonel Zeballos
 */
@Entity
@Table(
        name = "_user",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"username", "email"})}
)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User implements UserDetails {

    /**
     * The user id. It is generated automatically by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "_user_seq", sequenceName = "_user_seq", allocationSize = 1)
    private Long id;

    /**
     * The username. It is unique.
     */
    @Column(nullable = false)
    private String username;

    /**
     * The user password. It is encoded.
     */
    @Column(nullable = false)
    private String password;

    /**
     * The user email. It is unique.
     */
    @Column(nullable = false, unique = true)
    private String email;

    /**
     * If the user is enabled. It is used by Spring Security.
     */
    @Column(nullable = false)
    @Builder.Default
    private boolean enabled = true;

    /**
     * The account non expired flag. It is used by Spring Security.
     */
    @Column(nullable = false)
    @Builder.Default
    private boolean accountNonExpired = true;

    /**
     * The account non-locked flag. It is used by Spring Security.
     */
    @Column(nullable = false)
    @Builder.Default
    private boolean accountNonLocked = true;

    /**
     * The credentials non-expired flag. It is used by Spring Security.
     */
    @Column(nullable = false)
    @Builder.Default
    private boolean credentialsNonExpired = true;

    /**
     * The user creation date. By default, it is the current date.
     */
    @Column(updatable = false, nullable = false)
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();


    /**
     * The user roles.
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role")
    @Enumerated(EnumType.STRING)
    private List<Role> roles;


    /**
     * Returns the user authorities.
     * It is used by Spring Security.
     * Map the user roles to {@link GrantedAuthority}.
     *
     * @return The user authorities.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> (GrantedAuthority) role::name)
                .collect(Collectors.toList());
    }

    /**
     * Returns the user username. It is used by Spring Security.
     *
     * @return The user username. It is the document type + : + dni.
     */
    @Override
    public String getUsername() {
        return username;
    }

}
