package learningSpring.SpringBoot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NotFoundHandlingController {
    @GetMapping("/404")
    public String returnPage() {
        return "404";
    }
}



