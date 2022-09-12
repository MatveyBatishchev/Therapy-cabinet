package ru.mospolytech.therapy_cabinet.controller.med_index;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.mospolytech.therapy_cabinet.models.domain.IndexType;
import ru.mospolytech.therapy_cabinet.models.domain.medindex.MedIndexCreate;
import ru.mospolytech.therapy_cabinet.models.domain.medindex.MedIndexRead;

import java.util.List;


@RequestMapping("/med-index")
@Tag(name = "Клинический индекс")
@PreAuthorize("hasAnyAuthority('ADMINISTRATOR', 'DOCTOR', 'OPERATOR')")
public interface MedIndexController {

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Добавить индекс")
    void create(@RequestBody MedIndexCreate medIndex);

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить индекс по ID")
    MedIndexRead read(@PathVariable("id") Integer id);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Обновить информацию об индексе")
    void update(@PathVariable("id") Integer id,
                @RequestBody MedIndexCreate medIndex);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Удалить индекс по ID")
    void delete(@PathVariable("id") Integer id);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить список индексов")
    List<MedIndexCreate> readAll(@RequestParam(value = "offset", required = false) Long offset,
                                 @RequestParam(value = "limit", required = false) Long limit);

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить список всех отфильтрованных по параметрам индексов")
    List<MedIndexCreate> readAllBySearch(@RequestParam(name = "therapyId", required = false) Integer therapyId,
                                         @RequestParam(name = "indexType", required = false) IndexType indexType);
}
