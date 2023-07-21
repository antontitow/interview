package ru.titov.threads.multithreads.case2.v1;

import lombok.AllArgsConstructor;
import ru.titov.threads.multithreads.case2.v1.model.News;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 21.07.2023, 14:26
 **/
@AllArgsConstructor
public class NewsBussinessGenerator extends Thread {
    private static final String bussinessNews = "a new tax for companies with revenues over $1 billion";

    private News news;

    @Override
    public void run() {
        news.setBussiness(bussinessNews);
    }
}
