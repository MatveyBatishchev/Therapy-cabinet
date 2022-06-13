package ru.mospolytech.therapy_cabinet.mybatis.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import ru.mospolytech.therapy_cabinet.models.domain.therapy.TherapyCreate;
import ru.mospolytech.therapy_cabinet.models.domain.therapy.TherapyRead;

import java.util.List;

@Component
@Mapper
public interface TherapyMapper {

    void create(@Param("therapy") TherapyCreate therapy);

    TherapyRead read(@Param("id") int id);

    void update(@Param("therapyId") int id,
                @Param("therapy") TherapyCreate therapy);

    boolean delete(@Param("id") int id);

    List<TherapyRead> readAll(@Param("offset") Long offset,
                               @Param("limit") Long limit);
}
