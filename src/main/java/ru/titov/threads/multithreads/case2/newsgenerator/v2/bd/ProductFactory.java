package ru.titov.threads.multithreads.case2.newsgenerator.v2.bd;

import ru.titov.threads.multithreads.case2.newsgenerator.v2.model.Product;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 21.07.2023, 22:49
 **/
public class ProductFactory {
    public static List<Product> getProducts() {
        return Arrays.asList(new Product(1L, 200.00),
                new Product(2L, 7500.00),
                new Product(3L, 250.00),
                new Product(4L, 650.00),
                new Product(5L, 750.00),
                new Product(6L, 5000.00),
                new Product(7L, 200.00));
    }

    public static Map<Long, Double> getUserBonuses() {
        return Map.of(1L, 14.0,
                2L, 5.2,
                3L, 10.2);
    }

}
