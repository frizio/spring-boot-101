package dev.frizio.demo.controllers;

import dev.frizio.demo.configs.DemoProps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/props")
public class PropertiesController {

    @Value("${demo.message}")
    private String message;
    @Value("${demo.version}")
    private int version;

    @Value("${demo.javaHome}")
    private String javaHome;

    @Autowired
    private Environment environment;
    @Autowired
    private DemoProps demoProps;

    @GetMapping(value = "/value")
    public String logPropsWithValue() {
        log.info("Property 1: " + message);
        log.info("Property 2: " + version);
        log.info("Property 3 (from env): " + environment.getProperty("JAVA_HOME"));
        log.info("Property 4: (env variable referred from application.yml): " + javaHome);
        return "OK";
    }

    @GetMapping(value = "/class")
    public DemoProps getPropsFromConfigClass() {
        log.info(demoProps.toString());
        return demoProps;
    }

}
