package learningSpring.SpringBoot.controllers;

import learningSpring.SpringBoot.entities.Post;
import learningSpring.SpringBoot.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeletePostRestController {

    @Autowired
    PostService postService;
    @RequestMapping(value = "/delete", method= RequestMethod.DELETE)
    public void deletePost(@RequestParam("id") int id){
        postService.deletePost(id);
        return;
    }
}