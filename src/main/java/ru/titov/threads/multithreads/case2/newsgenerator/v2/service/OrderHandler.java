package ru.titov.threads.multithreads.case2.newsgenerator.v2.service;

import lombok.RequiredArgsConstructor;
import ru.titov.threads.multithreads.case2.newsgenerator.v2.model.Invoice;
import ru.titov.threads.multithreads.case2.newsgenerator.v2.model.Order;

import static java.lang.Thread.sleep;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 21.07.2023, 23:00
 **/

@RequiredArgsConstructor
public class OrderHandler {
    private final Order order;

    public Invoice orderHandle() throws InterruptedException {
        Invoice invoice = new Invoice();

        OrderBonusHandler orderBonusHandler = new OrderBonusHandler(invoice, order);
        orderBonusHandler.start();

        // Гарантируем запуск OrderBonusHandler первым. Он должен подсчитать сумму с бонусами только после того,
        // как другой поток посчитает сумму заказа
        sleep(100);
        new OrderCostHandler(invoice, order).start();


        // ждем подсчет бонусов и итоговой суммы
        try {
            orderBonusHandler.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        return invoice;
    }
}
