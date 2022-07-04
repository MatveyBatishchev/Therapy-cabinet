package ru.mospolytech.therapy_cabinet.mybatis.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import ru.mospolytech.therapy_cabinet.models.domain.Medication;

import java.util.List;


@Component
@Mapper
public interface MedicationMapper {

    void create(@Param("medication") Medication medication);

    Medication read(@Param("id") Integer id);

    void update(@Param("medication") Medication medication);

    boolean delete(@Param("id") Integer id);

    List<Medication> readAll(
            @Param("offset") Long offset,
            @Param("limit") Long limit
    );

}
