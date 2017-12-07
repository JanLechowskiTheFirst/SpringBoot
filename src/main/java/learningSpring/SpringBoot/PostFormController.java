package learningSpring.SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

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
        for(PostEntity post:postRepo.findAll()){
            if(post.getUserEmail().equals(email)) {
                posts.add(post);
            }
        }
        return "post";
    }

    @PostMapping("/post")
    public String postSubmit(@ModelAttribute PostForm postform ){
        return "post";
    }



    @RequestMapping("/post/{postValue}")  //TODO dodac przycisk z przekierowaniem na strone o takim formacie
    public String doPost(@PathVariable String postValue, @RequestParam(value="email") String email, Model model){
        model.addAttribute("post", postValue);
        postRepo.save(new PostEntity(postValue, userRepo.findOne(email).getLogin()));
        return "redirect:post.html";
    }

}




