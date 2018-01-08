package learningSpring.SpringBoot.controllers;

import learningSpring.SpringBoot.repositories.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomePageController {
    @Autowired
    private PostRepo postRepo;

    @RequestMapping("/")
    public String serveHomePage(){
        return "homePage";
    }

    @RequestMapping("/afterLoginPage")
    public String serveAfterLogin(){
        return "afterLogin";
    }
}

