package ru.mospolytech.therapy_cabinet.controller.lab_event;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.mospolytech.therapy_cabinet.models.domain.labevent.LabEventCreate;
import ru.mospolytech.therapy_cabinet.models.domain.labevent.LabEventRead;

import java.util.List;


@RequestMapping("/lab_event")
@Tag(name = "Анализ пациента")
public interface LabEventController {
    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Добавить анализ")
    void create(@RequestBody LabEventCreate labEvent);

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить анализ по ID")
    LabEventRead read(@PathVariable("id") Integer id);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Обновить информацию о анализе")
    void update(@PathVariable("id") Integer id,
                @RequestBody LabEventCreate labEvent);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Удалить анализ по ID")
    void delete(@PathVariable("id") Integer id);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить список анализов")
    List<LabEventRead> readAll(@RequestParam("offset") Long offset,
                               @RequestParam("limit") Long limit);
}
