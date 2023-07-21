package ru.titov.threads.loopRelation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 20.07.2023, 3:12
 **/
//@Configuration
public class Config {

//    @Bean(initMethod = "init")
    public W getW() {
        return new W();
    }
}
