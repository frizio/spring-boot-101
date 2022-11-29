package dev.frizio.demo.services.impl;

import dev.frizio.demo.services.I18nService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"ES", "default"})
@Service("i18nService")
public class I18nSpanishService implements I18nService {
    @Override
    public String sayGreeting() {
        return "Hola Mundo - ES";
    }
}