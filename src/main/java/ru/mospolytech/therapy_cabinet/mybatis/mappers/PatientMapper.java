package ru.mospolytech.therapy_cabinet.mybatis.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import ru.mospolytech.therapy_cabinet.models.domain.Patient;

import java.util.List;

@Component
@Mapper
public interface PatientMapper {
    void create(@Param("patient") Patient patient);

    Patient read(@Param("id") Integer id);

    void update(@Param("patient") Patient patient);

    boolean delete(@Param("id") Integer id);

    List<Patient> readAll(
            @Param("offset") Long offset,
            @Param("limit") Long limit
    );

    void addPatientIcd(
            @Param("patientId") Integer id,
            @Param("icdCode") String icdCode
    );

    List<String> readPatientIcds(
            @Param("patientId") Integer id
    );

    void removePatientIcd(
            @Param("patientId") Integer id,
            @Param("icdCode") String icdCode
    );
}
