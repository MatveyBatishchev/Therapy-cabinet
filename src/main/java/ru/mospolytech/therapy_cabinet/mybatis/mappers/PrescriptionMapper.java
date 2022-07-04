package ru.mospolytech.therapy_cabinet.mybatis.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import ru.mospolytech.therapy_cabinet.models.domain.prescription.AdministrationType;
import ru.mospolytech.therapy_cabinet.models.domain.prescription.PrescriptionCreate;
import ru.mospolytech.therapy_cabinet.models.domain.prescription.PrescriptionRead;

import java.util.List;


@Component
@Mapper
public interface PrescriptionMapper {

    void create(@Param("prescription") PrescriptionCreate prescription);

    PrescriptionRead read(@Param("id") Integer id);

    void update(@Param("id") Integer id, @Param("prescription") PrescriptionCreate presription);

    void delete(@Param("id") Integer id);

    List<PrescriptionCreate> readAll(@Param("offset") Long offset,
                                     @Param("limit") Long limit);

    PrescriptionRead readByTherapyId(@Param("therapyId") int id);

    List<PrescriptionCreate> readAllBySearch(@Param("medicationId") Integer medicationId,
                                             @Param("doseAmount") Integer doseAmount,
                                             @Param("substanceAmount") Double substanceAmount,
                                             @Param("administrationType") AdministrationType administrationType);
}
