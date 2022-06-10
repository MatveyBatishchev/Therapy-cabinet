package ru.mospolytech.therapy_cabinet.mybatis.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import ru.mospolytech.therapy_cabinet.models.domain.LabEvent;
import ru.mospolytech.therapy_cabinet.models.domain.LabEventCreate;
import ru.mospolytech.therapy_cabinet.models.domain.LabEventRead;

import java.util.List;
import java.util.UUID;

@Component
@Mapper
public interface LabEventMapper {
    void create(@Param("labEvent") LabEventCreate labEvent);

    LabEventRead read(@Param("id") UUID id);

    void update(@Param("labEventId") UUID id,
                @Param("labEvent") LabEventCreate labEvent);

    boolean delete(@Param("id") UUID id);

    List<LabEventRead> readAll(@Param("offset") Long offset,
                               @Param("limit") Long limit);
}
