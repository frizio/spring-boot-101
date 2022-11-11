package dev.frizio.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
  
  @RequestMapping(value = {"", "/", "index"})
  public String index(Model model) {
    model.addAttribute("username", "frizio dev");
    return "index.html";
  }

}
