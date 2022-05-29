package ru.mospolytech.therapy_cabinet.controller.patient;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.mospolytech.therapy_cabinet.models.domain.Patient;

import java.util.List;
import java.util.UUID;

@RequestMapping("/patient")
public interface PatientController {
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    Patient create(@RequestBody Patient patient);

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    Patient read(@PathVariable("id") UUID id);

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void update(@RequestBody Patient patient);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("id") UUID id);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    List<Patient> readAll(@RequestParam("offset") Long offset,
                          @RequestParam("limit") Long limit);
}
