package ru.titov.threads.headstack;

import lombok.extern.slf4j.Slf4j;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 17.07.2023, 23:52
 **/
@Slf4j
public class PersonBuilder {
    public static Person buildPerson(int id, String name) {
        return new Person(id, name);
    }


}
