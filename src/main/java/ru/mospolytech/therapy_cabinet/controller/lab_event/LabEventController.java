package ru.mospolytech.therapy_cabinet.controller.lab_event;

import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.mospolytech.therapy_cabinet.models.domain.LabEventCreate;
import ru.mospolytech.therapy_cabinet.models.domain.LabEventRead;

import java.util.List;
import java.util.UUID;

@RequestMapping("/lab_event")
public interface LabEventController {
    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void create(@RequestBody LabEventCreate labEvent);

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    LabEventRead read(@PathVariable("id") UUID id);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void update(@PathVariable("id") UUID id,
                @RequestBody LabEventCreate labEvent);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("id") UUID id);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<LabEventRead> readAll(@RequestParam("offset") Long offset,
                               @RequestParam("limit") Long limit);
}
