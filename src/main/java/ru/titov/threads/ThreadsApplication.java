package ru.titov.threads;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.titov.threads.multithreads.case2.v2.model.Invoice;
import ru.titov.threads.multithreads.case2.v2.model.Order;
import ru.titov.threads.multithreads.case2.v2.service.OrderHandler;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class ThreadsApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(ThreadsApplication.class, args);

        ApplicationContext context = new AnnotationConfigApplicationContext(ThreadsApplication.class);
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(ThreadsApplication.class);


        OrderHandler orderHandler = new OrderHandler(new Order(Arrays.asList(1L, 2L, 2L, 3L, 4L), 1L));
        Invoice invoice = orderHandler.orderHandle();
        log.info(invoice.toString());

    }
}
