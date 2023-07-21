package ru.titov.threads.multithreads.case2.v2.model;

import java.util.List;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 21.07.2023, 22:45
 **/

public record Order(List<Long> productCodeId, Long userId) {
}
