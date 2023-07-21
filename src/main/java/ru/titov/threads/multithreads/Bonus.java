package ru.titov.threads.multithreads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 18.07.2023, 17:00
 **/
@AllArgsConstructor
@Data
@Slf4j
public class Bonus extends Thread {
    private Invoice invoice;

    @Override
    public void run() {
        log.info("Customer 1 --> {}");


    }
}
