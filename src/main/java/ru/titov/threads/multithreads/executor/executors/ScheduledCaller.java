package ru.titov.threads.multithreads.executor.executors;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 23.07.2023, 17:15
 **/
@Slf4j
public class ScheduledCaller {

    public ScheduledCaller() throws InterruptedException, ExecutionException {
        log.info("Scheduled service start");
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Task task = new Task();
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture<String> res = scheduledExecutorService.schedule(task, 2, TimeUnit.SECONDS);
        while (!res.isDone()) {
            log.info("ждем");
        }
        log.info(res.get());
        scheduledExecutorService.awaitTermination(20, TimeUnit.SECONDS);
    }
}
