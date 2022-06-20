package ru.mospolytech.therapy_cabinet.mybatis.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import ru.mospolytech.therapy_cabinet.models.domain.order.OrderEntryCreate;
import ru.mospolytech.therapy_cabinet.models.domain.order.OrderEntryRead;

import java.util.List;

@Component
@Mapper
public interface OrderEntryMapper {

    void create(@Param("orderEntry") OrderEntryCreate orderEntry);

    OrderEntryRead read(@Param("id") int id);

    void update(@Param("id") int id,
                @Param("orderEntry") OrderEntryCreate orderEntry);

    boolean delete(@Param("id") int id);

    List<OrderEntryRead> readAll(@Param("offset") Long offset,
                                 @Param("limit") Long limit);

}
