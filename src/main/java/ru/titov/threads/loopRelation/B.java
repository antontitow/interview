package ru.titov.threads.loopRelation;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 20.07.2023, 1:20
 **/
@Component
@Slf4j
public class B {

    private final A a;

    public B(@Lazy A a) {
        this.a = a;
    }

    public void voiceB() {
        log.info("Voice B");
    }

//    @PostConstruct
    public void init(){
        log.info("B injected A");
    }
}
