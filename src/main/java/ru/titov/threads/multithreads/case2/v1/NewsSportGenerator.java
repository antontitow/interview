package ru.titov.threads.multithreads.case2.v1;

import lombok.AllArgsConstructor;
import ru.titov.threads.multithreads.case2.v1.model.News;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 21.07.2023, 14:26
 **/
@AllArgsConstructor
public class NewsSportGenerator extends Thread {
    private static final String sportNews = "Current chess champion is Din Lijan";

    private News news;

    @Override
    public void run() {
        news.setSport(sportNews);
    }
}
