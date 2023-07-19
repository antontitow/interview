package ru.titov.threads.headstack;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 17.07.2023, 23:44
 **/
@NoArgsConstructor
@Data
public
class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
