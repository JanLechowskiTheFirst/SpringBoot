package learningSpring.SpringBoot.UnitTests;

import learningSpring.SpringBoot.TestConfigurations.PostServiceTestConfig;
import learningSpring.SpringBoot.entities.Post;
import learningSpring.SpringBoot.repositories.PostRepo;
import learningSpring.SpringBoot.repositories.UserRepo;
import learningSpring.SpringBoot.services.PostService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {PostServiceTestConfig.class})
@RunWith(SpringRunner.class)
public class TestAllPostsAttrStringEmailShouldReturnListOfPosts {

    @MockBean
    PostRepo postRepo;
    @MockBean
    UserRepo userRepo;
    @Autowired
    PostService postService;

    @Test
    public void getAllPosts(){

        List<Post> postList = new ArrayList<>();
        postList.add(mock(Post.class));
        postList.add(mock(Post.class));
        postList.add(mock(Post.class));

        when(postRepo.findAllPostsByUserEmailSortedAsc("email")).thenReturn(postList);

        Assert.assertEquals(3, postService.getAllPosts("email").size());
    }
}
