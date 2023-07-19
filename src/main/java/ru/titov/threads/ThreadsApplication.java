package ru.titov.threads;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.titov.threads.loopRelation.A;
import ru.titov.threads.loopRelation.B;

@SpringBootApplication
@Slf4j
public class ThreadsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThreadsApplication.class, args);
        org.springframework.context.ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ThreadsApplication.class);
        A a = (A) context.getBeanFactory().getBean("a");
        B b = context.getBeanFactory().getBean(B.class);
        a.voiceA();
        log.info("--------");
        b.voiceB();
    }
}
