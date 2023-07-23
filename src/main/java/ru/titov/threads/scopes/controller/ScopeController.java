package ru.titov.threads.scopes.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import ru.titov.threads.scopes.service.ScopeInterface;

import static java.lang.Thread.sleep;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 23.07.2023, 19:52
 **/
@RestController("/")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
@RequestScope
public class ScopeController {
    private final ScopeInterface scopeInterface;
    private final ScopeInterface scopeInterface2;

    @GetMapping("get/{id}")
    public ResponseEntity<String> getScope(@PathVariable String id) throws InterruptedException {

        log.info("");
        log.info("Controller - {}", this.hashCode());
        log.info("-------------------------");


        scopeInterface.setLocalField(id);
        scopeInterface2.setLocalField("two");

        log.info("parent1 {}", scopeInterface.hashCode());
        log.info("parent2 {}", scopeInterface2.hashCode());
        log.info("");

        log.info(scopeInterface.getString());
        log.info(scopeInterface2.getString());

        log.info("-------------------------");

        sleep(10000);

        return ResponseEntity.ok("done");
    }
}
