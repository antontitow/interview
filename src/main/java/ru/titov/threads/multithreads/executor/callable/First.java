package ru.titov.threads.multithreads.executor.callable;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

import static java.lang.Thread.sleep;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 23.07.2023, 14:34
 **/
@AllArgsConstructor
@Slf4j
public class First implements Callable<Common> {
    private final Float value = 3.7f;

    private Common common;

    @Override
    public Common call() {
        for (int i = 1; i <= 5; i++) {
            common.addFloat(value);
        }

        return common;
    }

}
