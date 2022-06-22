package ru.mospolytech.therapy_cabinet.mybatis.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import ru.mospolytech.therapy_cabinet.models.domain.prescription.PrescriptionCreate;
import ru.mospolytech.therapy_cabinet.models.domain.prescription.PrescriptionRead;

import java.util.List;

@Component
@Mapper
public interface PrescriptionMapper {

    void create(@Param("prescription") PrescriptionCreate prescription);

    PrescriptionRead readByTherapyId(@Param("therapyId") int therapyId);

    void updateByTherapyId(@Param("therapyId") int therapyId, PrescriptionCreate prescription);

    void deleteByTherapyId(@Param("therapyId") int therapyId);

    List<PrescriptionCreate> readAll(@Param("offset") Long offset,
                                     @Param("limit") Long limit);

}
