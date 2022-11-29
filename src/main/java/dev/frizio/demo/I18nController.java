package dev.frizio.demo;

import dev.frizio.demo.services.I18nService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/ciao")
public class I18nController {

    private final I18nService i18nService;

    public I18nController(@Qualifier("i18nService") I18nService i18nService) {
        this.i18nService = i18nService;
    }

    @GetMapping(value = "")
    public String sayHello(){
        return i18nService.sayGreeting();
    }
}