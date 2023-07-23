package ru.titov.threads.multithreads.executor.callable;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 23.07.2023, 14:32
 **/
@Slf4j
@Data
public class Common {
    private float Float = 0.0f;

    public void addFloat(Float value) {
        log.info("Добавляем  {}", value);
        Float floatValue = getFloat();
        floatValue = floatValue + value;
        setFloat(floatValue);
    }

    public void subtractFloat(Float value) {
        log.info("Вычитаем {}", value);
        Float floatValue = getFloat();
        floatValue = floatValue - value;
        setFloat(floatValue);
    }
}
