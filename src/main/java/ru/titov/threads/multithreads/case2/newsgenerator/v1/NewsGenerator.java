package ru.titov.threads.multithreads.case2.newsgenerator.v1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import ru.titov.threads.multithreads.case2.model.News;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 21.07.2023, 14:35
 **/
//@Component
@RequiredArgsConstructor
@EnableScheduling
@Slf4j
public class NewsGenerator {
    private final ApplicationEventPublisher applicationEventPublisher;

    News news = new News();

    @Scheduled(fixedDelay = 30 * 1000L)
    @Async
    public void getNews() {
        log.info("Сбор новостей");

        synchronized (news) {
            new NewsBussinessGenerator(news).start();
            new NewsSportGenerator(news).start();
            new NewsWeatherGenerator(news).start();
        }

        log.info("публикация");
        applicationEventPublisher.publishEvent(news);

    }
}
