package ru.mospolytech.therapy_cabinet.mybatis.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import ru.mospolytech.therapy_cabinet.models.domain.IndexType;
import ru.mospolytech.therapy_cabinet.models.domain.medindex.MedIndexCreate;
import ru.mospolytech.therapy_cabinet.models.domain.medindex.MedIndexRead;

import java.util.List;


@Component
@Mapper
public interface MedIndexMapper {

    void create(@Param("medIndex") MedIndexCreate medIndex);

    MedIndexRead read(@Param("id") Integer id);

    void update(@Param("id") Integer id,
                @Param("medIndex") MedIndexCreate medIndex);

    boolean delete(@Param("id") Integer id);

    List<MedIndexCreate> readAll(@Param("offset") Long offset,
                                 @Param("limit") Long limit);

    List<MedIndexCreate> readAllBySearch(@Param("therapyId") Integer therapyId,
                                         @Param("indexType") IndexType indexType);

}
