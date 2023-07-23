package ru.titov.threads.multithreads.executor.executors;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 23.07.2023, 17:52
 **/
@Slf4j
@AllArgsConstructor
public class RunTask implements Runnable {
    private int i;

    @Override
    public void run() {
        log.info("Task{} runnable start", i);
    }
}
