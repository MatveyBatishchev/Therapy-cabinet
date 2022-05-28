package ru.mospolytech.therapy_room.mybatis.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import ru.mospolytech.therapy_room.models.domain.Patient;

import java.util.List;
import java.util.UUID;

@Component
@Mapper
public interface PatientMapper {
    void create(@Param("patient") Patient patient);
    Patient read(@Param("id") UUID id);
    void update(@Param("patient") Patient patient);

    boolean delete(@Param("id") UUID id);

    List<Patient> readAll(
            @Param("offset") Long offset,
            @Param("limit") Long limit
    );
}
