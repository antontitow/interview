package ru.titov.threads.multithreads.executor.callable;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 23.07.2023, 14:45
 **/
@Slf4j
public class Aggregator {
    public Aggregator() throws InterruptedException, ExecutionException {
        Common common = new Common();
        First first = new First(common);
        Second second = new Second(common);
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Future<Common> result1;
        Future<Common> result2;
        // без volatile и синхронизации методов
        synchronized (common) {
            result1 = executor.submit(first);
            result2 = executor.submit(second);
        }

        executor.awaitTermination(3, TimeUnit.SECONDS);
        log.info(String.valueOf(common.getFloat()));
        log.info(String.valueOf(result1.get()));
        log.info(String.valueOf(result2.get()));
        log.info(String.valueOf(common.getFloat()));
    }
}
