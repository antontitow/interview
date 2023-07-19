package ru.titov.threads.multithreads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 18.07.2023, 17:10
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@Slf4j
public class Customer2 implements Runnable {
    private Invoice invoice;
    private double pay;
    private long id;

    public Customer2(long i) {
        this.id = i;
    }

    @Override
    public void run() {
        log.info("Customer 2 --> {}", id);
    }
}
