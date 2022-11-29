package dev.frizio.demo.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

  @RequestMapping(value = {"", "/", "index"})
  public String index() {
    return "index.html";
  }

}
