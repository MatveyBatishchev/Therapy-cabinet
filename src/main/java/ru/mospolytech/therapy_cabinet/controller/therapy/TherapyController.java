package ru.mospolytech.therapy_cabinet.controller.therapy;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@RequestMapping("/therapy")
@Tag(name = "Терапия")
public interface TherapyController {

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Создать терапию")
    void create(@RequestBody TherapyCreate therapy);

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить терапию по ID")
    TherapyRead read(@PathVariable("id") int id);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Обновить информацию о терапии")
    void update(@PathVariable("id") int id,
                @RequestBody TherapyCreate therapy);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Удалить терапию по ID")
    void delete(@PathVariable("id") int id);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить список терапий")
    List<TherapyCreate> readAll(@RequestParam(value = "offset", required = false) Long offset,
                                @RequestParam(value = "limit", required = false) Long limit);

    @GetMapping("/calendar")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "")
    List<Calendar> readTherapyCalendar(@RequestParam("start_date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                                       @RequestParam("end_date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate);

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить список всех отфильтрованных по параметрам терапий")
    List<TherapyCreate> readAllBySearch(@RequestParam(name="patientId", required = false) Integer patientId,
                                        @RequestParam(name="startDate", required = false)
                                        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                                        @RequestParam(name="endDate", required = false)
                                        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate,
                                        @RequestParam(name="time-period", required = false) TimePeriod timePeriod,
                                        @RequestParam(name="status", required = false) TherapyStatus therapyStatus);
}
