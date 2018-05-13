package learningSpring.SpringBoot.controllers;

import learningSpring.SpringBoot.entities.Post;
import learningSpring.SpringBoot.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModifyPostRestController {


    @Autowired PostService postService;
    @RequestMapping(value = "/modify", method= RequestMethod.PUT)
    public void modifyPost(@RequestBody Post post){
        postService.modifyPost(post);
        return;
    }
}
