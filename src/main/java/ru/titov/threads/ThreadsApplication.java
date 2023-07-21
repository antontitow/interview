package ru.titov.threads;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.titov.threads.multithreads.Bill;
import ru.titov.threads.multithreads.Invoice;
import ru.titov.threads.multithreads.order.Order;
import ru.titov.threads.multithreads.products.BedProduct;
import ru.titov.threads.multithreads.products.FurnitureProduct;
import ru.titov.threads.multithreads.products.Product;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@Slf4j
public class ThreadsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThreadsApplication.class, args);

        ApplicationContext context = new AnnotationConfigApplicationContext(ThreadsApplication.class);
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(ThreadsApplication.class);

        Bill bill = new Bill();
        List<Product> products = Arrays.asList(
                new FurnitureProduct(1L, null, null),
                new BedProduct(2L, null, null),
                new FurnitureProduct(3L, null, null),
                new BedProduct(4L, null, null),
                new BedProduct(1L, null, null),
                new BedProduct(2L, null, null),
                new FurnitureProduct(3L, null, null),
                new BedProduct(4L, null, null)
        );
        Order order = Order.builder().products(products).build();
        bill.processAllOrders(new Invoice(), order);
    }
}
