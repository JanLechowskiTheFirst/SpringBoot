package learningSpring.SpringBoot.controllers;

import learningSpring.SpringBoot.forms.UserForm;
import learningSpring.SpringBoot.services.SecurityService;
import learningSpring.SpringBoot.services.UserService;
import learningSpring.SpringBoot.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    UserService userService;
    @Autowired
    SecurityService securityService;
    @Autowired
    UserValidator validator;

    @RequestMapping("/login")
    public String serveLoginnPage(){
        return "loginPage";
    }

    @GetMapping("/register")
    public String registrationForm(Model model){
        model.addAttribute("UserForm", new UserForm());
        return "registrationPage";
    }

    @PostMapping("/register")
    public String submittRegistrationForm(@ModelAttribute("UserForm") UserForm form, BindingResult bindingResult, Model model){
        validator.validate(form, bindingResult);

        if(bindingResult.hasErrors()){
            return "/registrationPage";

        }
        userService.addUserToDB(form);
        securityService.autologin(form.getEmail(), form.getPassword());

        return "redirect:/post";
    }
}