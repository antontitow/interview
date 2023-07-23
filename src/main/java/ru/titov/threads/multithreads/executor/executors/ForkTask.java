package ru.titov.threads.multithreads.executor.executors;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.RecursiveTask;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 23.07.2023, 18:16
 **/
@AllArgsConstructor
@Slf4j
public class ForkTask extends RecursiveTask<String> {
    private int i;

    @Override
    protected String compute() {
        return null;
    }

//    @Override
//    protected String compute() {
//        log.info("run {}", i);
//        return "Fork";
//    }
}
