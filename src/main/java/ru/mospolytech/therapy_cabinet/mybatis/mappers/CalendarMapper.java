package ru.mospolytech.therapy_cabinet.mybatis.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Component;
import ru.mospolytech.therapy_cabinet.models.domain.Calendar;

import java.util.List;

@Component
@Mapper
public interface CalendarMapper {

    List<Calendar> read(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}