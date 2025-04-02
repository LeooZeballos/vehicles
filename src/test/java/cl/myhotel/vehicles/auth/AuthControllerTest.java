package cl.myhotel.vehicles.auth;

import cl.myhotel.vehicles.dto.request.LoginRequest;
import cl.myhotel.vehicles.dto.request.RefreshRequest;
import cl.myhotel.vehicles.dto.request.RegisterRequest;
import cl.myhotel.vehicles.dto.response.TokenResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class AuthControllerTest {

    private AuthController authController;

    @Mock
    private IAuthService authService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        authController = new AuthController(authService);
    }

    @Test
    void testLogin_Success() {
        // Create test data
        LoginRequest loginRequest = new LoginRequest("username", "password");
        TokenResponse tokenResponse = TokenResponse.builder().token("access-token").build();
        when(authService.login(loginRequest)).thenReturn(tokenResponse);

        // Perform the test
        ResponseEntity<TokenResponse> response = authController.login(loginRequest);

        // Verify the response
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(tokenResponse, response.getBody());

        // Verify that the authService.login() method was called
        verify(authService, times(1)).login(loginRequest);
    }

    @Test
    void testLogin_InvalidCredentials() {
        // Create test data
        LoginRequest loginRequest = new LoginRequest("username", "password");
        String errorMessage = "Invalid credentials";
        when(authService.login(loginRequest)).thenThrow(new IllegalArgumentException(errorMessage));

        // Perform the test
        ResponseEntity<TokenResponse> response = authController.login(loginRequest);

        // Verify the response
        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(errorMessage, response.getBody().error());

        // Verify that the authService.login() method was called
        verify(authService, times(1)).login(loginRequest);
    }

    @Test
    void testLogin_InternalServerError() {
        // Create test data
        LoginRequest loginRequest = new LoginRequest("username", "password");
        String errorMessage = "Internal Server Error";
        when(authService.login(loginRequest)).thenThrow(new RuntimeException(errorMessage));

        // Perform the test
        ResponseEntity<TokenResponse> response = authController.login(loginRequest);

        // Verify the response
        assertNotNull(response);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(errorMessage, response.getBody().error());

        // Verify that the authService.login() method was called
        verify(authService, times(1)).login(loginRequest);
    }

    @Test
    void testRegister_Success() {
        // Create test data
        RegisterRequest registerRequest = new RegisterRequest("username", "password", "email");
        TokenResponse tokenResponse = TokenResponse.builder().token("access-token").build();
        when(authService.register(registerRequest)).thenReturn(tokenResponse);

        // Perform the test
        ResponseEntity<TokenResponse> response = authController.register(registerRequest);

        // Verify the response
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(tokenResponse, response.getBody());

        // Verify that the authService.register() method was called
        verify(authService, times(1)).register(registerRequest);
    }

    @Test
    void testRegister_InternalServerError() {
        // Create test data
        RegisterRequest registerRequest = new RegisterRequest("username", "password", "email");
        String errorMessage = "Internal Server Error";
        when(authService.register(registerRequest)).thenThrow(new RuntimeException(errorMessage));

        // Perform the test
        ResponseEntity<TokenResponse> response = authController.register(registerRequest);

        // Verify the response
        assertNotNull(response);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(errorMessage, response.getBody().error());

        // Verify that the authService.register() method was called
        verify(authService, times(1)).register(registerRequest);
    }

    @Test
    void testRefresh_Success() {
        // Create test data
        RefreshRequest refreshRequest = new RefreshRequest("refresh-token");
        TokenResponse tokenResponse = TokenResponse.builder().token("new-access-token").build();
        when(authService.refreshToken(refreshRequest)).thenReturn(tokenResponse);

        // Perform the test
        ResponseEntity<TokenResponse> response = authController.refresh(refreshRequest);

        // Verify the response
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(tokenResponse, response.getBody());

        // Verify that the authService.refreshToken() method was called
        verify(authService, times(1)).refreshToken(refreshRequest);
    }

    @Test
    void testRefresh_InvalidRefreshToken() {
        // Create test data
        RefreshRequest refreshRequest = new RefreshRequest("refresh-token");
        String errorMessage = "Invalid refresh token";
        when(authService.refreshToken(refreshRequest)).thenThrow(new IllegalArgumentException(errorMessage));

        // Perform the test
        ResponseEntity<TokenResponse> response = authController.refresh(refreshRequest);

        // Verify the response
        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(errorMessage, response.getBody().error());

        // Verify that the authService.refreshToken() method was called
        verify(authService, times(1)).refreshToken(refreshRequest);
    }

    @Test
    void testRefresh_InternalServerError() {
        // Create test data
        RefreshRequest refreshRequest = new RefreshRequest("refresh-token");
        String errorMessage = "Internal Server Error";
        when(authService.refreshToken(refreshRequest)).thenThrow(new RuntimeException(errorMessage));

        // Perform the test
        ResponseEntity<TokenResponse> response = authController.refresh(refreshRequest);

        // Verify the response
        assertNotNull(response);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(errorMessage, response.getBody().error());

        // Verify that the authService.refreshToken() method was called
        verify(authService, times(1)).refreshToken(refreshRequest);
    }

}