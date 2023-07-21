package ru.titov.threads.scopes;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 20.07.2023, 2:12
 **/
@Component
@Scope("prototype")
@NoArgsConstructor
@Data
@Slf4j
public class Picture {
    private String field = "field";

    public void show() {
        log.info(String.valueOf(this.hashCode()));
        log.info(String.valueOf(this));
    }
}
