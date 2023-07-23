package ru.titov.threads.multithreads.executor.blocking;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 23.07.2023, 14:32
 **/
@Slf4j
@Data
public class Common {
    private float floatVal = 0.0f;

    public void addFloat(Float value) throws InterruptedException {

        if (floatVal > 7.0) {
            wait();
        }

        log.info("Добавляем  {}", value);
        Float floatValue = getFloatVal();
        floatValue = floatValue + value;
        setFloatVal(floatValue);
    }

    public void subtractFloat(Float value) {
        if (floatVal > 7.0) {
            notify();
        }
        log.info("Вычитаем {}", value);
        Float floatValue = getFloatVal();
        floatValue = floatValue - value;
        setFloatVal(floatValue);
    }
}
