package ru.mospolytech.therapy_cabinet.mybatis.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import ru.mospolytech.therapy_cabinet.models.domain.order.MedOrder;

import java.util.List;


@Component
@Mapper
public interface MedOrderMapper {

    void create(@Param("medOrder") MedOrder medOrder);

    MedOrder read(@Param("id") Integer id);

    void update(@Param("medOrder") MedOrder medOrder);

    boolean delete(@Param("id") Integer id);

    List<MedOrder> readAll(
            @Param("offset") Long offset,
            @Param("limit") Long limit
    );

}
