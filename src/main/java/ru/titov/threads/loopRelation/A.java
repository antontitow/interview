package ru.titov.threads.loopRelation;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 20.07.2023, 1:19
 **/

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class A {

    private final B b;

    public A(@Lazy B b) {
        this.b = b;
    }

    public void voiceA() {
        log.info("Voice A");
        b.voiceB();
    }
}
