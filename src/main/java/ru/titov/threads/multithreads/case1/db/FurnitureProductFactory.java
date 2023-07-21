package ru.titov.threads.multithreads.case1.db;

import ru.titov.threads.multithreads.case1.products.FurnitureProduct;

import java.util.Arrays;
import java.util.List;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 21.07.2023, 1:35
 * some data db
 **/
public class FurnitureProductFactory {
    private FurnitureProductFactory() {
    }

    private static FurnitureProductFactory instance;

    public static FurnitureProductFactory getFurnitureProductFactory() {

        if (instance == null) {
            instance = new FurnitureProductFactory();
        }

        return instance;
    }

    public List<FurnitureProduct> getProducts() {
        return Arrays.asList(
                new FurnitureProduct(1L, "chair black skin", 2000.30),
                new FurnitureProduct(2L, "chair black tissue", 1750.04),
                new FurnitureProduct(3L, "chair wooden", 2300.08),
                new FurnitureProduct(4L, "chair green soft", 1750.56),
                new FurnitureProduct(5L, "table black stone 1000*1300", 4500.77)

        );
    }
}
