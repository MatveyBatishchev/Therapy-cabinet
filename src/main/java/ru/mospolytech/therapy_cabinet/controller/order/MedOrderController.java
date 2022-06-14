package ru.mospolytech.therapy_cabinet.controller.order;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.mospolytech.therapy_cabinet.models.domain.order.MedOrder;

import java.util.List;
import java.util.UUID;

@RequestMapping("/medorder")
public interface MedOrderController {

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void create(@RequestBody MedOrder medOrder);

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    MedOrder read(@PathVariable("id") UUID id);

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void update(@RequestBody MedOrder medOrder);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("id") UUID id);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<MedOrder> readAll(@RequestParam("offset") Long offset,
                           @RequestParam("limit") Long limit);

}
