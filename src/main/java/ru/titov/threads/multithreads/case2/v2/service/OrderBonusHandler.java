package ru.titov.threads.multithreads.case2.v2.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.titov.threads.multithreads.case2.v2.bd.ProductFactory;
import ru.titov.threads.multithreads.case2.v2.model.Invoice;
import ru.titov.threads.multithreads.case2.v2.model.Order;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 21.07.2023, 23:16
 **/
@AllArgsConstructor
@Slf4j
public class OrderBonusHandler extends Thread {
    private Invoice invoice;
    private Order order;

    @Override
    public void run() {

        log.info("Подсчитываем сумму со скидкой");

        log.info("userId {}", order.userId());
        Double discont = ProductFactory.getUserBonuses().get(order.userId());

        //Если в "базе" нет юзера
        if (discont == null) {
            discont = 0.00;
        }

        log.info("Определена скидка (%) для данного клиента {}", discont);

        if (discont != null) {
            invoice.calculateResultAmount(discont);
        }
    }
}
