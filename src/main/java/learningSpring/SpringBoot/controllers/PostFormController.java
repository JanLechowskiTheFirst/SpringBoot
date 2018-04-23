package learningSpring.SpringBoot.controllers;

import learningSpring.SpringBoot.forms.PostForm;
import learningSpring.SpringBoot.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostFormController {

    @Autowired
    PostService postService;

    @GetMapping("/post")
    public String postForm(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        model.addAttribute("postForm", new PostForm());
        model.addAttribute("post", postService.getAllPosts(userEmail));
        return "postPage";
    }

    @PostMapping("/post")
    public String postSubmit(@ModelAttribute("postForm") PostForm postform){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        postService.addNewPost(userEmail, postform);
        return "redirect:/post";
    }

}




