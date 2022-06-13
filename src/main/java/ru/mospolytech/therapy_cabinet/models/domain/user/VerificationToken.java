package ru.mospolytech.therapy_cabinet.models.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Dimevision
 * @version 0.1
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VerificationToken {
    /**
     * Токен для подтверждения регистрации
     */
    private UUID token;
    /**
     * Время создания токена
     */
    private LocalDateTime createdAt;
    /**
     * Время истечения срока действия токена
     */
    private LocalDateTime expiredAt;
    /**
     * Время подтверждения регистрации
     */
    private LocalDateTime confirmedAt;
    /**
     * UUID пользователя (внешний ключ)
     */
    private UUID userUuid;
}
