package top.actualself.springboot.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafController {

    @RequestMapping("/index")
    public String thymeleafHello(Model model) {
        model.addAttribute("hello", "welcome thymeleaf world");
        return "index";
    }
}
