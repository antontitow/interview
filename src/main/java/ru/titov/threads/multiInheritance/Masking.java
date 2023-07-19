package ru.titov.threads.multiInheritance;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 16.07.2023, 22:47
 **/
public interface Masking {
    default String mask(String string){
        return "*" +string.substring(1,string.length());
    }
}
