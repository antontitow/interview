package ru.titov.threads.multithreads.case1.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 21.07.2023, 1:20
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    private Long id;
    private String description;
    private Double cost;
}
