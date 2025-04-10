package cl.myhotel.vehicles.dto.request;

import org.springframework.lang.NonNull;

/**
 * A request to register a new user. This class is used to map the request body to an object.
 *
 * @author Leonel Zeballos
 */
public record RegisterRequest(
        @NonNull String username,
        @NonNull String password,
        @NonNull String email
) {
}
