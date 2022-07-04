package ru.mospolytech.therapy_cabinet.controller.lab_type;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.mospolytech.therapy_cabinet.models.domain.LabType;

import java.util.List;

@RequestMapping("/lab_type")
@Tag(name = "Вид анализа")
public interface LabTypeController {
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Добавить вид анализа")
    LabType create(@RequestBody LabType labType);

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить вид анализа по ID")
    LabType read(@PathVariable("id") int id);

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Обновить информацию о виде анализа")
    void update(@RequestBody LabType labType);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Удалить вид анализа по ID")
    void delete(@PathVariable("id") int id);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить список видов анализов")
    List<LabType> readAll(@RequestParam("offset") Long offset,
                          @RequestParam("limit") Long limit);
}
