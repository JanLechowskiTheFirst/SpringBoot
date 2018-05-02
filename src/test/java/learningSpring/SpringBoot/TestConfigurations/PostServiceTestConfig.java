package learningSpring.SpringBoot.TestConfigurations;


import learningSpring.SpringBoot.services.PostService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostServiceTestConfig {
    @Bean
    PostService postService() {
        return new PostService();
    }

}

