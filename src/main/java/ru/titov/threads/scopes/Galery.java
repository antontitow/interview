package ru.titov.threads.scopes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 20.07.2023, 2:10
 **/
@Component
@Slf4j
@RequiredArgsConstructor
public class Galery {

        private final Picture picture;
//    @Lookup
//    public Picture getPicture() {
//        return null;
//    }

    public void open() {
//        Picture picture = getPicture();
//        picture.setField("one");
//        picture.show();
//
//        Picture picture2 = getPicture();
//        picture.setField("two");
//        picture2.show();


//        log.info(String.valueOf(picture == picture));

        log.info(picture.getField());
        picture.setField("qwerf");

    }

}
