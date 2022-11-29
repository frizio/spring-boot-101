package dev.frizio.demo.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {

  @Autowired
  private Environment environment;

  @Value("${demo.message}")
  private String message;

  @Value("${demo.version}")
  private int version;

  @RequestMapping(value = {"", "/", "index"})
  public String index() {
    log.info("Property 1: " + message);
    log.info("Property 2: " + version);
    log.info("Property 3 (from env): " + environment.getProperty("JAVA_HOME"));
    return "index.html";
  }

}
