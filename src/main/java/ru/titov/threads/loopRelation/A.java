package ru.titov.threads.loopRelation;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 20.07.2023, 1:19
 **/

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Description("A have B relation, and B relation on A")
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

//    @PostConstruct
    public void init(){
        log.info("A injected B");
    }
}
