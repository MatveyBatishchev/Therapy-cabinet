package ru.mospolytech.therapy_cabinet.controller.patient;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.mospolytech.therapy_cabinet.models.domain.Patient;

import java.util.List;

@RequestMapping("/patient")
@Tag(name = "Пациент")
public interface PatientController {
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Добавить пациента")
    Patient create(@RequestBody Patient patient);

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить пациента по ID")
    Patient read(@PathVariable("id") Integer id);

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Обновить информацию о пациенте")
    void update(@RequestBody Patient patient);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Удалить пациента по ID")
    void delete(@PathVariable("id") Integer id);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить список пациентов")
    List<Patient> readAll(@RequestParam(value = "offset", required = false) Long offset,
                          @RequestParam(value = "limit", required = false) Long limit);

    @PostMapping("/{id}/icd")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Добавить диагноз МКБ")
    void addPatientIcd(@PathVariable("id") Integer id,
                       @RequestParam("icdCode") String icdCode);


    @GetMapping("/{id}/icd")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить список диагнозов МКБ")
    List<String> readPatientIcds(@PathVariable("id") Integer id);

    @DeleteMapping("/{id}/icd")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Удалить диагноз МКБ")
    void removePatientIcd(@PathVariable("id") Integer id,
                          @RequestParam("icdCode") String icdCode);
}
