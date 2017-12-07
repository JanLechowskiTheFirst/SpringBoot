package learningSpring.SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginFormController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/index")
    public String loginForm(String email, Model model) {
        model.addAttribute("login", new LoginForm());
        if (userRepo.findOne(email).getLogin().equals(email)) {
            //TODO dodaj do sesji
            return "redirect:post.html";
        } else {
            return "Błędny login lub hasło";
        }
    }

    @PostMapping("/index")
    public String loginSubmit(@ModelAttribute LoginForm login){
        return "login";
    }

}
