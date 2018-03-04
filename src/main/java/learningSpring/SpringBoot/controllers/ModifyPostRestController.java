package learningSpring.SpringBoot.controllers;

import learningSpring.SpringBoot.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/modify/{post}/{id}")
public class ModifyPostRestController {

    @Autowired PostService postService;
    @RequestMapping(method= RequestMethod.PUT)
    public String modifyPost(String post, Integer id){
          postService.modifyPost(post, id);
          System.out.println(post + "," + id);
          return "{stauts:'ok'}";
    }
}
