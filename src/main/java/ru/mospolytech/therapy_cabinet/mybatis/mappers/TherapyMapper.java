package ru.mospolytech.therapy_cabinet.mybatis.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Component;
import ru.mospolytech.therapy_cabinet.models.domain.therapy.TherapyCreate;
import ru.mospolytech.therapy_cabinet.models.domain.therapy.TherapyRead;

import java.util.List;
import java.util.UUID;

@Component
@Mapper
public interface TherapyMapper {

    void create(@Param("therapy") TherapyCreate therapy);

    TherapyRead read(@Param("id") int id);

    void update(@Param("id") int id,
                @Param("therapy") TherapyCreate therapy);

    boolean delete(@Param("id") int id);

    List<TherapyCreate> readAll(@Param("offset") Long offset,
                                @Param("limit") Long limit);

    List<TherapyCreate> readAllByPatientId(@Param("patientId") UUID patientId,
                                           @Param("startDate") LocalDate startDate,
                                           @Param("endDate") LocalDate endDate);
}
