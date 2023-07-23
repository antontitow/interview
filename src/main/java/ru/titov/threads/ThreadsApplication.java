package ru.titov.threads;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.concurrent.ExecutionException;

@SpringBootApplication
@Slf4j
@ComponentScan()
public class ThreadsApplication {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        SpringApplication.run(ThreadsApplication.class, args);

//        ApplicationContext context = new AnnotationConfigApplicationContext(ThreadsApplication.class);
//        BeanFactory beanFactory = new AnnotationConfigApplicationContext(ThreadsApplication.class);


//        new ForkJoinCaller();

    }
}
