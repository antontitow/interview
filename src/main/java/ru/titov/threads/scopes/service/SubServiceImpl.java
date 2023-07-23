package ru.titov.threads.scopes.service;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 23.07.2023, 20:19
 **/
@Service
@Slf4j
@NoArgsConstructor
@Scope("prototype")
public class SubServiceImpl implements SubService {

}
