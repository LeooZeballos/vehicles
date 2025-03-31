package cl.myhotel.vehicles.auth;

import cl.myhotel.vehicles.model.Role;
import cl.myhotel.vehicles.model.User;
import cl.myhotel.vehicles.repository.UserRepository;
import cl.myhotel.vehicles.request.RegisterRequest;
import cl.myhotel.vehicles.response.TokenResponse;
import cl.myhotel.vehicles.request.LoginRequest;
import cl.myhotel.vehicles.request.RefreshRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The user service implementation. It implements {@link IAuthService}.
 * It is annotated with {@link Service} to be automatically scanned and injected.
 * It is annotated with {@link RequiredArgsConstructor} to inject final fields.
 *
 * @see IAuthService
 * @author Leonel Zeballos
 */
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {

    /**
     * The user repository.
     */
    private final UserRepository userRepository;

    /**
     * The JWT encoder.
     */
    private final JwtEncoder jwtEncoder;

    /**
     * The JWT decoder.
     */
    private final JwtDecoder jwtDecoder;

    /**
     * The JWT expiration time in seconds.
     */
    private final static long JWT_EXPIRATION_TIME = 60 * 60; // 1 hour


    /**
     * Register a new user. It also generates a JWT token.
     * Username has to be unique.
     * Username has to be unique.
     * Email also has to be unique.
     *
     * @param registerRequest The register request.
     */
    @Override
    public TokenResponse register(RegisterRequest registerRequest) {
        // Validate user
        if (userRepository.existsByUsername(registerRequest.username())) {
            throw new IllegalArgumentException("DNI already exists");
        }

        if (userRepository.existsByEmail(registerRequest.email())) {
            throw new IllegalArgumentException("Email already exists");
        }

        // Crate user
        User newUser = User.builder()
                .username(registerRequest.username())
                .password(registerRequest.password())
                .email(registerRequest.email())
                .roles(List.of(Role.USER))
                .build();

        // Save user
        newUser = userRepository.saveAndFlush(newUser);

        // Generate token
        return generateToken(newUser);
    }

    /**
     * Login a user. It generates a JWT token.
     *
     * @param loginRequest The login request.
     * @return The token response.
     */
    @Override
    public TokenResponse login(LoginRequest loginRequest) {
        // Validate user credentials
        try {
            // Search user
            User user = loadUser(loginRequest.username());

            // Validate password
            if (!user.getPassword().equals(loginRequest.password())) {
                throw new IllegalArgumentException("Invalid credentials for " + loginRequest.username());
            }

            // Generate token
            return generateToken(user);
        } catch (UsernameNotFoundException e) {
            throw new IllegalArgumentException("Invalid credentials for " + loginRequest.username());
        }
    }

    /**
     * Generate a JWT token.
     *
     * @param user The user.
     * @return The token response.
     */
    public TokenResponse generateToken(UserDetails user) {
        // Generate a JWT token
        Instant now = Instant.now();

        // Generate scope
        String scope = user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));

        // Generate claims
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(JWT_EXPIRATION_TIME))
                .subject(user.getUsername())
                .claim("scope", scope)
                .build();

        // Generate token from claims
        return TokenResponse.builder()
                .token(jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue())
                .build();
    }

    /**
     * Refresh a JWT token.
     *
     * @param refreshToken The refresh token.
     * @return The token response.
     */
    @Override
    public TokenResponse refreshToken(RefreshRequest refreshToken) {
        // Decode the refresh token
        Jwt jwt = jwtDecoder.decode(refreshToken.token());

        // Get the claims
        Map<String, Object> claims = jwt.getClaims();

        // Get the user
        UserDetails user = loadUserByUsername(claims.get("sub").toString());

        // Validate the scope
        if (!user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "))
                .equals(claims.get("scope").toString())) {
            throw new IllegalArgumentException("Invalid scope");
        }

        // Validate the expiration time
        if (jwt.getExpiresAt() != null && Instant.now().isAfter(jwt.getExpiresAt())) {
            throw new IllegalArgumentException("Token expired");
        }

        // Generate a new token
        return generateToken(user);
    }

    /**
     * Load a user by username.
     *
     * @param username The username.
     * @return The user details.
     * @throws UsernameNotFoundException If the user is not found.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    /**
     * Load a user by username.
     *
     * @param username The username.
     * @return The user details.
     * @throws UsernameNotFoundException If the user is not found.
     */
    public User loadUser(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    /**
     * Get the current user from the JWT token.
     *
     * @param token The JWT token.
     * @return The user details.
     * @throws UsernameNotFoundException If the user is not found.
     */
    public User getCurrentUser(JwtAuthenticationToken token) throws UsernameNotFoundException {
        Jwt jwt = token.getToken();
        String username = jwt.getClaim("sub");
        return loadUser(username);
    }

}
