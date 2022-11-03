package dev.frizio.demo.controller;

import org.springframework.stereotype.Controller;

@Controller
public class IndexController {
  
  public String index() {
    return "index.html";
  }

}
