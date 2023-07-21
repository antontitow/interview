package ru.titov.threads.multithreads.db;

import ru.titov.threads.multithreads.products.BedProduct;

import java.util.Arrays;
import java.util.List;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 21.07.2023, 1:24
 * some data db
 **/
public class BedProductFactory {
    private BedProductFactory() {
    }

    private static BedProductFactory instance;

    public static BedProductFactory getBedFactory() {

        if (instance == null) {
            instance = new BedProductFactory();
        }

        return instance;
    }

    public List<BedProduct> getProducts() {
        return Arrays.asList(
                new BedProduct(1L, "pillow 200x200", 200.00),
                new BedProduct(2L, "pillow 250x250", 250.00),
                new BedProduct(3L, "pillow 3000x310", 285.00),
                new BedProduct(4L, "blanket 1200x1500", 822.00),
                new BedProduct(5L, "blanket 2000x1800", 1250.00),
                new BedProduct(6L, "blanket 2000x2200", 1400.00)
        );
    }
}
