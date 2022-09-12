package ru.mospolytech.therapy_cabinet.controller.prescription;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.mospolytech.therapy_cabinet.models.domain.prescription.AdministrationType;
import ru.mospolytech.therapy_cabinet.models.domain.prescription.PrescriptionCreate;
import ru.mospolytech.therapy_cabinet.models.domain.prescription.PrescriptionRead;

import java.util.List;


@RequestMapping("/prescription")
@Tag(name = "Лекарственные назначения")
@PreAuthorize("hasAnyAuthority('ADMINISTRATOR', 'DOCTOR', 'OPERATOR')")
public interface PrescriptionController {

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Создать назначение")
    void create(@RequestBody PrescriptionCreate prescription);

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить назначение по ID")
    PrescriptionRead read(@PathVariable("id") Integer id);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Обновить информацию о лекарственном назначении")
    void update(@PathVariable("id") Integer id,
                @RequestBody PrescriptionCreate prescription);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Удалить назначение по ID")
    void delete(@PathVariable("id") Integer id);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить список назначений")
    List<PrescriptionCreate> readAll(@RequestParam(value = "offset", required = false) Long offset,
                                     @RequestParam(value = "limit", required = false) Long limit);

    @GetMapping("/by-therapy")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить назначение по ID терапии")
    PrescriptionRead readByTherapyId(@RequestParam("therapyId") int therapyId);


    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить список всех отфильтрованных по параметрам назначений")
    List<PrescriptionCreate> readAllBySearch(@RequestParam(name="medicationId", required = false) Integer medicationId,
                                             @RequestParam(name="doseAmount", required = false) Integer doseAmount,
                                             @RequestParam(name="substanceAmount", required = false) Double substanceAmount,
                                             @RequestParam(name="administrationType", required = false) AdministrationType administrationType);
}
