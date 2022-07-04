package ru.mospolytech.therapy_cabinet.mybatis.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import ru.mospolytech.therapy_cabinet.models.domain.LabType;

import java.util.List;


@Component
@Mapper
public interface LabTypeMapper {
    void create(@Param("labType") LabType labType);

    LabType read(@Param("id") int id);

    void update(@Param("labType") LabType labType);

    boolean delete(@Param("id") int id);

    List<LabType> readAll(
            @Param("offset") Long offset,
            @Param("limit") Long limit
    );
}
