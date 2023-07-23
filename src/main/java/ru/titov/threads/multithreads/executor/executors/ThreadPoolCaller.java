package ru.titov.threads.multithreads.executor.executors;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 23.07.2023, 17:42
 **/
@Slf4j
public class ThreadPoolCaller {
    public ThreadPoolCaller() throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2));

        for (int i = 0; i < 5; i++) {
            threadPoolExecutor.execute(new RunTask(i));
        }

    }
}
