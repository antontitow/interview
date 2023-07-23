package ru.titov.threads.multithreads.executor.callable;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 23.07.2023, 14:43
 **/

@AllArgsConstructor
@Slf4j
public class Second implements Callable<Common> {
    private final Float value = 1.0f;

    private Common common;

    @Override
    public Common call() {
        for (int i = 1; i <= 5; i++) {
            common.subtractFloat(value);
        }


        return common;
    }


}
