package ru.mospolytech.therapy_cabinet.controller.medication;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.mospolytech.therapy_cabinet.models.domain.Medication;

import java.util.List;
import java.util.UUID;

@RequestMapping("/medication")
public interface MedicationController {

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void create(@RequestBody Medication medication);

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    Medication read(@PathVariable("id") UUID id);

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void update(@RequestBody Medication medication);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("id") UUID id);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<Medication> readAll(@RequestParam("offset") Long offset,
                          @RequestParam("limit") Long limit);

}
