package cl.myhotel.vehicles.service;

import cl.myhotel.vehicles.model.User;
import cl.myhotel.vehicles.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * Service for loading user details.
 * This service implements {@link UserDetailsService} to provide user details for authentication.
 *
 * @see UserDetailsService
 * @see User
 * @see UserRepository
 * @author Leonel Zeballos
 */
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.emptyList()
        );
    }
}
