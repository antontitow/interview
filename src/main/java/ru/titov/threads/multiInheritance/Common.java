package ru.titov.threads.multiInheritance;

import lombok.extern.slf4j.Slf4j;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 16.07.2023, 22:54
 **/
@Slf4j
public class Common implements Suffix, Masking {
    @Override
    public String mask(String string) {
        log.info(Masking.super.mask(string));
        log.info(Suffix.super.mask(string));
        return "";
    }
}
