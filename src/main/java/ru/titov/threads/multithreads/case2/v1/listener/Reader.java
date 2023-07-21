package ru.titov.threads.multithreads.case2.v1.listener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.titov.threads.multithreads.case2.v1.model.News;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 21.07.2023, 13:09
 **/
@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Slf4j
public class Reader {
    private Long id;

    @EventListener(News.class)
    public void handleNews(News news) {
        log.info("Текущие новости \n");
        log.info("{} \n", news.toString());

    }
}
