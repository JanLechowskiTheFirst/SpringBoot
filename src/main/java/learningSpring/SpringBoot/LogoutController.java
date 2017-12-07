package learningSpring.SpringBoot;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class LogoutController {

    @RequestMapping("/logout")
    public String logout(@RequestParam(value="email") String email, Model model){
        //TODO zakończ sesje
        return "redirect:index.html";
    }

}
