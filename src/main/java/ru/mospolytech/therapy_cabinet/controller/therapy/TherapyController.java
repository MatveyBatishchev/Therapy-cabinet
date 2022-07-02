package ru.mospolytech.therapy_cabinet.controller.therapy;

import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.mospolytech.therapy_cabinet.models.domain.Calendar;
import ru.mospolytech.therapy_cabinet.models.domain.therapy.TherapyCreate;
import ru.mospolytech.therapy_cabinet.models.domain.therapy.TherapyRead;
import ru.mospolytech.therapy_cabinet.models.domain.therapy.TherapyStatus;
import ru.mospolytech.therapy_cabinet.models.domain.therapy.TimePeriod;

import java.util.List;
import java.util.UUID;

@RequestMapping("/therapy")
public interface TherapyController {

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void create(@RequestBody TherapyCreate therapy);

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    TherapyRead read(@PathVariable("id") int id);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void update(@PathVariable("id") int id,
                @RequestBody TherapyCreate therapy);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("id") int id);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<TherapyCreate> readAll(@RequestParam("offset") Long offset,
                                @RequestParam("limit") Long limit);

    @GetMapping("/calendar")
    @ResponseStatus(HttpStatus.OK)
    List<Calendar> readTherapyCalendar(@RequestParam("start_date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                                       @RequestParam("end_date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate);

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    List<TherapyCreate> readAllBySearch(@RequestParam(name="patientId", required = false) UUID patientId,
                                        @RequestParam(name="startDate", required = false)
                                        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                                        @RequestParam(name="endDate", required = false)
                                        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate,
                                        @RequestParam(name="time-period", required = false) TimePeriod timePeriod,
                                        @RequestParam(name="status", required = false) TherapyStatus therapyStatus);


}
