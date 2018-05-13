package learningSpring.SpringBoot.IntegrationTests;

import learningSpring.SpringBoot.TestConfigurations.LoginPageConfig;
import learningSpring.SpringBoot.controllers.PostFormController;
import learningSpring.SpringBoot.entities.Post;
import learningSpring.SpringBoot.repositories.PostRepo;
import learningSpring.SpringBoot.repositories.UserRepo;
import learningSpring.SpringBoot.services.PostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = PostFormController.class)
@ContextConfiguration(classes = LoginPageConfig.class)
public class IntegrationTestLoginPage {

    @Autowired
    PostService postService;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PostRepo postRepo;

    @MockBean
    UserRepo userRepo;

    @Test
    public void loginPage() throws Exception{

        List<Post> postList = new ArrayList<>();

        when(postRepo.findAllPostsByUserEmailSortedAsc(anyString())).thenReturn(postList);

        mockMvc.perform(MockMvcRequestBuilders.get("/login"))
                .andExpect(status().is(200));

    }
}
