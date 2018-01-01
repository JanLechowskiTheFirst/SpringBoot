package learningSpring.SpringBoot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {

    @RequestMapping("/")
    public String serveHomePage(){
        return "homePage";
    }
    @RequestMapping("/afterLoginPage")
    public String serveAfterLogin(){
        return "afterLogin";
    }
}
