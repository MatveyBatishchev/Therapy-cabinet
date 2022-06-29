package ru.mospolytech.therapy_cabinet.models.domain.redis;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Dimevision
 * @version 0.1
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("RefreshToken")
public class RefreshToken implements Serializable {
    private static final long serialVersionUID = 881597705214943359L;

    @Id
    @Indexed
    private String token;

    private Date expiredAt;

    private String userId;
}
