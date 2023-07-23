package ru.titov.threads.multithreads.executor.executors;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ForkJoinPool;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 23.07.2023, 18:03
 **/
@Slf4j
public class ForkJoinCaller {
    public ForkJoinCaller() {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

//        for (int i = 0; i < 4; i++) {
//            forkJoinPool.invoke(new ForkTask(i));
//        }

//        new ForkTask(1).fork();
//        new ForkTask(2).fork();
//        new ForkTask(3).fork();
//        new ForkTask(4).fork();

//        String s1 = new ForkTask(1).fork().join();
//        String s2 = new ForkTask(2).fork().join();
//        String s3 = new ForkTask(3).fork().join();
//        String s4 = new ForkTask(4).fork().join();
//        log.info(s1);
//        log.info(s2);
//        log.info(s3);
//        log.info(s4);

    }
}
