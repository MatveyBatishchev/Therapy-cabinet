package ru.mospolytech.therapy_cabinet.controller.medication;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.mospolytech.therapy_cabinet.models.domain.Medication;

import java.util.List;


@RequestMapping("/medication")
@Tag(name = "Лекарственный препарат")
public interface MedicationController {

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Добавить препарат")
    void create(@RequestBody Medication medication);

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить препарат по ID")
    Medication read(@PathVariable("id") Integer id);

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Обновить информацию о препарате")
    void update(@RequestBody Medication medication);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Удалить препарат по ID")
    void delete(@PathVariable("id") Integer id);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить список препаратов")
    List<Medication> readAll(@RequestParam("offset") Long offset,
                             @RequestParam("limit") Long limit);

}
