package ru.mospolytech.therapy_cabinet.mybatis.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import ru.mospolytech.therapy_cabinet.models.domain.Medication;

import java.util.List;
import java.util.UUID;

@Component
@Mapper
public interface MedicationMapper {

    void create(@Param("medication") Medication medication);

    Medication read(@Param("id") UUID id);

    void update(@Param("medication") Medication medication);

    boolean delete(@Param("id") UUID id);

    List<Medication> readAll(
            @Param("offset") Long offset,
            @Param("limit") Long limit
    );

}
