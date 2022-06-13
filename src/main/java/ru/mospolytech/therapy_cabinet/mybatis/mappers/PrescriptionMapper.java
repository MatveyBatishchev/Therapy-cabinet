package ru.mospolytech.therapy_cabinet.mybatis.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import ru.mospolytech.therapy_cabinet.models.domain.prescription.PrescriptionCreate;
import ru.mospolytech.therapy_cabinet.models.domain.prescription.PrescriptionRead;

import java.util.List;
import java.util.UUID;

@Component
@Mapper
public interface PrescriptionMapper {

    void create(@Param("prescription") PrescriptionCreate prescription);

    PrescriptionRead read(@Param("id") UUID id);

    void update(@Param("id") UUID id,
                @Param("prescription") PrescriptionCreate prescription);

    boolean delete(@Param("id") UUID id);

    List<PrescriptionRead> readAll(@Param("offset") Long offset,
                                   @Param("limit") Long limit);

}
