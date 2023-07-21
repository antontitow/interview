package ru.titov.threads.multithreads.case1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.titov.threads.multithreads.case1.order.Order;
import ru.titov.threads.multithreads.case1.processors.BedCostProccessor;
import ru.titov.threads.multithreads.case1.processors.FurnitureCostProccessor;
import ru.titov.threads.multithreads.case1.products.BedProduct;
import ru.titov.threads.multithreads.case1.products.FurnitureProduct;
import ru.titov.threads.multithreads.case1.products.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 18.07.2023, 17:10
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@Slf4j
public class Bill {
    private final int maxThreadsPool = 3;
    private Invoice invoice;
    private Order order;
    private boolean run = true;

    /**
     * Получаем счет и заказ.
     * Каждый вид продукта (мебель, постельное белье) находится в разных базах.
     * Нельзя использовать больше n числа потоков одновременно. Задано по умолчанию 3
     *
     * @param invoice - счет
     * @param order   - список продуктов - может быть как мебель, так и постельное белье.
     * @return сумму заказа
     */
    public Double processAllOrders(Invoice invoice, Order order) {
        return processAllOrders(invoice, order, maxThreadsPool);
    }

    /**
     * Получаем счет и заказ.
     * Каждый вид продукта (мебель, постельное белье) находится в разных базах.
     * Нельзя использовать больше n числа потоков одновременно
     *
     * @param invoice - счет
     * @param order   - список продуктов - может быть как мебель, так и постельное белье.
     * @param maxPool - число максимальных потоков одновременно
     * @return сумму заказа
     */
    private Double processAllOrders(Invoice invoice, Order order, int maxPool) {
        log.info("");

        List<Product> products = order.getProducts();
        int size = products.size();

        log.info("Передано {} продуктов", size);
        log.info("");

        int pool = maxPool > size ? size : maxPool;
        int steps = 0;
        int poolNumber = 0;
        List<Product> productsTmp = new ArrayList<>();

        /**
         * формируем пакеты по N продуктов (не больше)
         */
        for (Product product : products) {

            steps++;
            productsTmp.add(product);
            pool--;

            if (pool <= 0) {
                poolNumber++;
                getCost(invoice, productsTmp, poolNumber);
                productsTmp = new ArrayList<>();
                size = size - steps;
                steps = 0;
                pool = maxPool > size ? size : maxPool;
                log.info("");
            }
        }

        log.info("Вся сумма {}", invoice.getBalance());

        return invoice.getBalance();
    }

    private void getCost(Invoice invoice, List<? extends Product> productList, int poolNumber) {
        log.info("пул {} стартует", poolNumber);
        List<Thread> threads = new ArrayList<>();
        productList.stream().forEach(product -> {
            /**
             * Определяем какой вид продукта и передаем расчет в отдельный поток
             */
            if (product instanceof FurnitureProduct) {
                getFurnitureCost(invoice, product.getId(), threads);
            } else if (product instanceof BedProduct) {
                getBedCost(invoice, product.getId(), threads);
            }
        });

        while (threads.stream().filter(thread -> thread.isAlive()).count() > 0){
            log.info("ожидаем завершения пула");
        }

        log.info("пул {} отработал", poolNumber);

    }


    private void getBedCost(Invoice invoice, Long productId, List<Thread> threads) {
        BedCostProccessor bedCostProccessor = new BedCostProccessor(invoice, productId);
        threads.add(bedCostProccessor);
        bedCostProccessor.start();
    }

    private void getFurnitureCost(Invoice invoice, Long productId, List<Thread> threads) {
        FurnitureCostProccessor furnitureCostProccessor = new FurnitureCostProccessor(invoice, productId);
        threads.add(furnitureCostProccessor);
        furnitureCostProccessor.start();
    }


}
