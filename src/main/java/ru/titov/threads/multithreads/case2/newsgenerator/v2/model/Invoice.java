package ru.titov.threads.multithreads.case2.newsgenerator.v2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 21.07.2023, 22:42
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Slf4j
public class Invoice {
    private volatile Double costWithDiscount = 0.0;
    private volatile Double cost = 0.0;
    private volatile Double discountPercent = 0.0;
    private boolean costCalculated = false;

    public synchronized Double getCost() {
        return cost;
    }

    public synchronized void setCost(Double cost) {
        this.cost = cost;
    }

    public synchronized void continued() {
        setCostCalculated(true);
        notify();
    }

    public synchronized Double getDiscountPercent() {
        return discountPercent;
    }

    public synchronized void setDiscountPercent(Double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public synchronized void calculateResultAmount(Double discont) {
        if (!isCostCalculated()) {
            try {
                log.info("Ожидаем подсчета суммы заказа");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        setDiscountPercent(discont);
        Double result = getCost().doubleValue() * (100.00 - discont.doubleValue()) / 100;
        setCostWithDiscount(result);
    }
}
