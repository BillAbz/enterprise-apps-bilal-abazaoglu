package be.ehb.enterpriseappbilalabazaoglu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home() {
        return "redirect:/events";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
