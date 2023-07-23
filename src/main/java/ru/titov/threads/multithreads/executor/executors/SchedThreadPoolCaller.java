package ru.titov.threads.multithreads.executor.executors;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 23.07.2023, 18:00
 **/
@Slf4j
public class SchedThreadPoolCaller {
    public SchedThreadPoolCaller() throws ExecutionException, InterruptedException {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor =
                new ScheduledThreadPoolExecutor(5);
        ScheduledFuture<String> res = scheduledThreadPoolExecutor.schedule(new Task(), 5, TimeUnit.SECONDS);

        while (!res.isDone()) {

        }
        log.info(String.valueOf(res.get()));
    }
}
