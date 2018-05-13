package learningSpring.SpringBoot.controllers;

import learningSpring.SpringBoot.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeletePostRestController {

    @Autowired
    PostService postService;
    @RequestMapping(value = "/delete1", method= RequestMethod.DELETE)
    public void deletePost(@RequestParam("id") int id){
        postService.deletePost(id);
        return;
    }
}