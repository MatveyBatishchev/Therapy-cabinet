package ru.mospolytech.therapy_cabinet.mybatis.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import ru.mospolytech.therapy_cabinet.models.domain.labevent.LabEventCreate;
import ru.mospolytech.therapy_cabinet.models.domain.labevent.LabEventRead;

import java.util.List;


@Component
@Mapper
public interface LabEventMapper {
    void create(@Param("labEvent") LabEventCreate labEvent);

    LabEventRead read(@Param("id") Integer id);

    void update(@Param("labEventId") Integer id,
                @Param("labEvent") LabEventCreate labEvent);

    boolean delete(@Param("id") Integer id);

    List<LabEventRead> readAll(@Param("offset") Long offset,
                               @Param("limit") Long limit);
}
