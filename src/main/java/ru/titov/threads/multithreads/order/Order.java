package ru.titov.threads.multithreads.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.titov.threads.multithreads.products.Product;

import java.util.List;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 21.07.2023, 1:44
 **/
@AllArgsConstructor
@Data
@Builder
public class Order {
    private List<Product> products;
}
