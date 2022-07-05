package ru.mospolytech.therapy_cabinet.controller.order;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.mospolytech.therapy_cabinet.models.domain.order.MedOrder;

import java.util.List;


@RequestMapping("/medorder")
@Tag(name = "Заказ", description = "Заказы в аптеку")
public interface MedOrderController {

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Добавить заказ")
    void create(@RequestBody MedOrder medOrder);

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить заказ по ID")
    MedOrder read(@PathVariable("id") Integer id);

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Обновить информацию о заказе")
    void update(@RequestBody MedOrder medOrder);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Удалить заказ по ID")
    void delete(@PathVariable("id") Integer id);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить список заказов")
    List<MedOrder> readAll(@RequestParam(value = "offset", required = false) Long offset,
                           @RequestParam(value = "limit", required = false) Long limit);
}
