package learningSpring.SpringBoot.UnitTests;

import learningSpring.SpringBoot.TestConfigurations.PostServiceTestConfig;
import learningSpring.SpringBoot.entities.Post;
import learningSpring.SpringBoot.repositories.PostRepo;
import learningSpring.SpringBoot.repositories.UserRepo;
import learningSpring.SpringBoot.services.PostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.mock;


@ContextConfiguration(classes = {PostServiceTestConfig.class})
@RunWith(SpringRunner.class)
public class TestModifyPostAttrPost {

    @MockBean
    PostRepo postRepo;
    @MockBean
    UserRepo userRepo;
    @Autowired
    PostService postService;

    @Test
    public void modifyPost(){
        postService.modifyPost(mock(Post.class));
    }
}

