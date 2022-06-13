package ru.mospolytech.therapy_cabinet.mybatis.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import ru.mospolytech.therapy_cabinet.models.domain.user.VerificationToken;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Dimevision
 * @version 0.1
 */

@Component
@Mapper
public interface VerificationTokenMapper {

    Optional<VerificationToken> findByToken(@Param("token") UUID token);

    void saveVerificationToken(@Param("token") VerificationToken verificationToken);

    void updateVerificationToken(@Param("token") VerificationToken verificationToken);

    void removeUserAndTokenByToken(@Param("token") UUID token);
}
