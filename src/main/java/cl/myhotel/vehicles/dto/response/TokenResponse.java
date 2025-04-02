package cl.myhotel.vehicles.dto.response;

import lombok.Builder;

/**
 * Represents a token response with a token and an error message.
 * Either token or error will be null.
 *
 * @param token The generated token for the user.
 * @param error An error message if the token generation failed.
 */
@Builder
public record TokenResponse(String token, String error) {
}
