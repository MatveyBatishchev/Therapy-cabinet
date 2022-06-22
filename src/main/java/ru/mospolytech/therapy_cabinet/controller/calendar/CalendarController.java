package ru.mospolytech.therapy_cabinet.controller.calendar;

import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.mospolytech.therapy_cabinet.models.domain.Calendar;

import java.util.List;

@RequestMapping("/calendar")
public interface CalendarController {

    @GetMapping("/calendar")
    @ResponseStatus(HttpStatus.OK)
    List<Calendar> getCalendarDensity(@RequestParam("start_date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                                      @RequestParam("end_date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate);

}
