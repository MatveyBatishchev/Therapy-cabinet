package ru.mospolytech.therapy_cabinet.controller.calendar;

import lombok.AllArgsConstructor;
import org.joda.time.LocalDate;
import org.springframework.web.bind.annotation.RestController;
import ru.mospolytech.therapy_cabinet.models.domain.Calendar;
import ru.mospolytech.therapy_cabinet.mybatis.mappers.CalendarMapper;

import java.util.List;

@RestController
@AllArgsConstructor
public class CallendarControllerImpl implements CalendarController {

    private final CalendarMapper calendarMapper;

    @Override
    public List<Calendar> getCalendarDensity(LocalDate startDate, LocalDate endDate) {
        return calendarMapper.read(startDate, endDate);
    }

}
