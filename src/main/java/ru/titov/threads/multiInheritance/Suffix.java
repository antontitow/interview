package ru.titov.threads.multiInheritance;

import org.apache.commons.lang3.StringUtils;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 16.07.2023, 22:50
 **/
public interface Suffix {
    default String mask(String string){
        return StringUtils.rightPad(string,10,"*");
    }
}
