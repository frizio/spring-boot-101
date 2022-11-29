package dev.frizio.demo.services.impl;

import dev.frizio.demo.services.I18nService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("EN")
@Service("i18nService")
public class I18nEnglishService implements I18nService {

    @Override
    public String sayGreeting() {
        return "Hello World - EN";
    }

}