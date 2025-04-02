package cl.myhotel.vehicles.dto.request;

import org.springframework.lang.NonNull;

/**
 * A request to login. This class is used to map the request body to an object.
 *
 * @author Leonel Zeballos
 */
public record LoginRequest(
        @NonNull String username,
        @NonNull String password
) {
}
