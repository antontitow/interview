package ru.titov.threads.multithreads.case2.newsgenerator.v1;

import lombok.AllArgsConstructor;
import ru.titov.threads.multithreads.case2.model.News;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 21.07.2023, 14:26
 **/
@AllArgsConstructor
public class NewsWeatherGenerator extends Thread {
    private static final String weather = "Cold";

    private News news;

    @Override
    public void run() {
        news.setWeather(weather);

    }
}
