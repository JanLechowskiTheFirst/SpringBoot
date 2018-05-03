package learningSpring.SpringBoot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NotAuthorizedHandlingController {

    @GetMapping("/403")
    public String returnPage(){
        return "403";
    }
}
