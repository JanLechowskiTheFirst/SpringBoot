package learningSpring.SpringBoot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminPageController {

    @RequestMapping("/admin/admin")
    public String serveLoginnPage(){
        return "adminPage";
    }
}

