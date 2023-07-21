package ru.titov.threads.multithreads.case2.v2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 21.07.2023, 22:50
 **/
@AllArgsConstructor
@Data
public class Product {
    private Long id;
    private Double cost;
}
