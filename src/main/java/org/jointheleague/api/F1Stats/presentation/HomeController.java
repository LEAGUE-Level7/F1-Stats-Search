package org.jointheleague.api.F1Stats.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
            return "redirect:swagger-ui.html";
    }
    @ResponseStatus(HttpStatus.MOVED_PERMANENTLY);
}