package learningSpring.SpringBoot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServerDownHandlingController {
    @GetMapping("/500")
    public String returnPage() {
        return "500";
    }
}
