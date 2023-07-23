package ru.titov.threads.multithreads.executor.blocking;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 23.07.2023, 14:45
 **/
@Slf4j
public class AggregatorFuture {
    public AggregatorFuture() throws InterruptedException {
        Common common = new Common();
        First first = new First(common);
        Second second = new Second(common);
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // без volatile и синхронизации методов

            executor.submit(first);
            executor.submit(second);


        executor.awaitTermination(3, TimeUnit.SECONDS);
        log.info(String.valueOf(common.getFloatVal()));
    }
}
