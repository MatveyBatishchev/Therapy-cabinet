package ru.mospolytech.therapy_cabinet.controller.index_type;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.mospolytech.therapy_cabinet.models.domain.IndexType;

import java.util.List;

@RequestMapping("/index-type")
public interface IndexTypeController {

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void create(@RequestBody IndexType indexType);

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    IndexType read(@PathVariable("id") int id);

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void update(@RequestBody IndexType indexType);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("id") int id);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<IndexType> readAll(@RequestParam("offset") Long offset,
                            @RequestParam("limit") Long limit);

}
