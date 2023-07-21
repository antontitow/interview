package ru.titov.threads.multithreads.case2.v2.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.titov.threads.multithreads.case2.v2.bd.ProductFactory;
import ru.titov.threads.multithreads.case2.v2.model.Invoice;
import ru.titov.threads.multithreads.case2.v2.model.Order;
import ru.titov.threads.multithreads.case2.v2.model.Product;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 21.07.2023, 23:05
 **/
@AllArgsConstructor
@Slf4j
public class OrderCostHandler extends Thread {
    private Invoice invoice;
    private Order order;

    @Override
    public void run() {
        log.info("Подсчитываем стоимость заказа без бонусов");
        List<Product> productsInBase = ProductFactory.getProducts();
        AtomicReference<Double> cost = new AtomicReference<>(0.0);
        order.productCodeId()
                .stream()
                .forEach(productId -> productsInBase.stream()
                        .forEach(productInBase -> {
                                    if (productInBase.getId() == productId) {
                                        cost.set(cost.get() + productInBase.getCost().doubleValue());
                                    }
                                }
                        ));
        invoice.setCost(cost.get());
        log.info("Стоимость подсчитана");
        log.info("invoice: {}", invoice.toString());
        invoice.continued();
    }
}
