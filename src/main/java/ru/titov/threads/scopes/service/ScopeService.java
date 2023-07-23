package ru.titov.threads.scopes.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 23.07.2023, 19:53
 **/
@Service
@Slf4j
@Data
@Scope("prototype")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ScopeService implements ScopeInterface {
    private String local = "local";
    private final SubService service;

    @Override
    public String getString() {
        log.info("class {}", this.hashCode());
        log.info("subclass {}", service.hashCode());

        return local;
    }

    @Override
    public void setLocalField(String value) {
        this.local = value;
    }

}
