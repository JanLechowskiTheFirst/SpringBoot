package learningSpring.SpringBoot.UnitTests;

import learningSpring.SpringBoot.TestConfigurations.PostServiceTestConfig;
import learningSpring.SpringBoot.entities.Post;
import learningSpring.SpringBoot.forms.PostForm;
import learningSpring.SpringBoot.repositories.PostRepo;
import learningSpring.SpringBoot.repositories.UserRepo;
import learningSpring.SpringBoot.services.PostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;



@ContextConfiguration(classes = {PostServiceTestConfig.class})
@RunWith(SpringRunner.class)

public class TestAddNewPostAttStringPostForm {

    @MockBean
    PostRepo postRepo;
    @MockBean
    UserRepo userRepo;
    @Autowired
    PostService postService;

    @Test
    public void addNewPost(){
        PostForm postForm = mock(PostForm.class);
        when(userRepo.findUserIdByEmail("email")).thenReturn(1);
        when(postForm.getPostText()).thenReturn("abc");
        when(postRepo.saveAndFlush(any(Post.class))).thenReturn(mock(Post.class));
        postService.addNewPost("email", postForm);
    }
}

