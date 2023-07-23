package ru.titov.threads.multithreads.executor.executors;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 23.07.2023, 17:26
 **/
@NoArgsConstructor
@Slf4j
public class Task implements Callable<String> {
    @Override
    public String call() throws Exception {
        log.info("task execute");

        return String.valueOf(LocalDateTime.now());
    }
}
