package learningSpring.SpringBoot.controllers;

import learningSpring.SpringBoot.entities.PostEntity;
import learningSpring.SpringBoot.repositories.PostRepo;
import learningSpring.SpringBoot.repositories.UserRepo;
import learningSpring.SpringBoot.forms.PostForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PostFormController {
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private UserRepo userRepo;
    private ArrayList<PostEntity> posts;

    @GetMapping("/post")
    public String postForm(@RequestParam(value="email") String email, Model model){
        model.addAttribute("post", new PostForm());
        List<PostEntity> allPosts = postRepo.findByEmail(email);
        return "posts";
    }

    @PostMapping("/post")
    public String postSubmit(@ModelAttribute PostForm postform ){
        return "posts";
    }



    @RequestMapping("/post/{postValue}")
    public String doPost(@PathVariable String postValue, @RequestParam(value="email") String email, Model model){
        model.addAttribute("post", postValue);
        postRepo.save(new PostEntity(postValue, email));
        return "redirect:posts";
    }

}




