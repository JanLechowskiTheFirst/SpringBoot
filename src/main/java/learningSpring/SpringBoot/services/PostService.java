package learningSpring.SpringBoot.services;

import learningSpring.SpringBoot.entities.Post;
import learningSpring.SpringBoot.forms.PostForm;
import learningSpring.SpringBoot.repositories.PostRepo;
import learningSpring.SpringBoot.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
public class PostService{
    @Autowired
    PostRepo postRepo;
    @Autowired
    UserRepo userRepo;

    public List<Post> getAllPosts(String email){
        return postRepo.findByUserId(userRepo.findOneByMail(email).getId());
    }

    public void addNewPost(String email, PostForm postform){
        Post post = new Post(userRepo.findOneByMail(email).getId(), postform.getPostText());
        postRepo.saveAndFlush(post);
    }

    public List<Post> getSortedPosts(String email){
        List<Post> posts = getAllPosts(email);
        Collections.sort(posts);
        return posts;
    }
}