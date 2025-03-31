package cl.myhotel.vehicles.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class LoginDTO {
    private String token;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
}
