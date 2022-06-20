package ru.mospolytech.therapy_cabinet.mybatis.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import ru.mospolytech.therapy_cabinet.models.domain.IndexType;

import java.util.List;

@Component
@Mapper
public interface IndexTypeMapper {

    void create(@Param("indexType") IndexType indexType);

    IndexType read(@Param("id") int id);

    void update(@Param("indexType") IndexType indexType);

    boolean delete(@Param("id") int id);

    List<IndexType> readAll(
            @Param("offset") Long offset,
            @Param("limit") Long limit
    );

}
