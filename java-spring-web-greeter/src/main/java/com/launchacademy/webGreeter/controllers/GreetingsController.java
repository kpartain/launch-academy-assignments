package com.launchacademy.webGreeter.controllers;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/greetings")
public class GreetingsController {

 @GetMapping("/default")
 public String getDefaultGreeting(Model model) {
   model.addAttribute("greeting", "Hello from Spring");
   return "greetings/show";
 }

  @GetMapping("/by-query-string")
  public String getQueryStringGreeting(@RequestParam(required = false) String firstName, String lastName, Model model) {
     if (firstName != null && lastName != null) {
         model.addAttribute("greeting", "Hello from Spring, " + firstName + lastName);
     } else if (firstName != null && lastName == null) {
        model.addAttribute("greeting", "Hello from Spring, " + firstName);
    } else if (firstName == null && lastName != null) {
        model.addAttribute("greeting", "Hello from Spring.");
    }
    return "greetings/show";
  }

  @GetMapping("/by-language")
  public String getLanguageGreeting(@RequestParam(required = false) String lang, Model model) {
     if(lang.equals("fr")){
         model.addAttribute("greeting", "Bounjour from Spring");
     } else if (lang.equals("es")) {
         model.addAttribute("greeting", "Hola from Spring");
     } else if(lang.equals("en")) {
         model.addAttribute("greeting", "Hello from Spring");
     }
     return "greetings/show";
  }


  @GetMapping("/by-name/{name}")
  public String getCustomizedGreeting(@PathVariable String name, Model model) {
    model.addAttribute("greeting", "Hello from Spring, " + name);
    return "greetings/show";
  }
}
