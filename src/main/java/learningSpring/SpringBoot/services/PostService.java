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
    private PostRepo postRepo;
    @Autowired
    private UserRepo userRepo;

    public List<Post> getAllPosts(String email){
        return postRepo.findAllPostsByUserEmailSortedAsc(email);
    }

    public void addNewPost(String email, PostForm postform){
        Post post = new Post(userRepo.findUserIdByEmail(email), postform.getPostText());
        postRepo.saveAndFlush(post);
    }

    public void modifyPost(Post post){
        postRepo.saveAndFlush(post);
    }

    public void deletePost(int id){
        postRepo.delete(id);
    }
}