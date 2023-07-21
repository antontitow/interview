package ru.titov.threads.multithreads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 18.07.2023, 16:57
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Invoice {
    private volatile Double balance = 0.0;
}
