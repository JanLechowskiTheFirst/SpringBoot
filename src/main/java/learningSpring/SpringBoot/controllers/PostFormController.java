package learningSpring.SpringBoot.controllers;

import learningSpring.SpringBoot.entities.Post;
import learningSpring.SpringBoot.forms.PostForm;
import learningSpring.SpringBoot.repositories.PostRepo;
import learningSpring.SpringBoot.repositories.UserRepo;
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
    private PostRepo postRepo;
    @Autowired UserRepo userRepo;

    @GetMapping("/post")
    public String postForm(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        model.addAttribute("postForm", new PostForm());
        model.addAttribute("post", postRepo.findByUserId(userRepo.findOneByMail(email).getId()));
        return "postPage";
    }

    @PostMapping("/post")
    public String postSubmit(@ModelAttribute("postForm") PostForm postform){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Post post = new Post(userRepo.findOneByMail(email).getId(), postform.getPostText());
        postRepo.saveAndFlush(post);
        return "redirect:/post";
    }



//    @RequestMapping("/post/{postValue}")
//    public String addNewPost(@PathVariable String postValue, @RequestParam(value="email") String email, Model model){
//        model.addAttribute("post", postValue);
//        postRepo.save(new Post(postValue, email));
//        return "postPage";
//    }

}




