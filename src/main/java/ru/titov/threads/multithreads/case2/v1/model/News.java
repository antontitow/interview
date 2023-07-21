package ru.titov.threads.multithreads.case2.v1.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 21.07.2023, 14:19
 **/
@NoArgsConstructor
@Data
public class News {
    private String bussiness;
    private String sport;
    private String weather;
}
