package learningSpring.SpringBoot.TestConfigurations;

import learningSpring.SpringBoot.configuration.SecurityConfig;
import learningSpring.SpringBoot.services.PostService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class LoginPageConfig {
    @Bean
    PostService postService() {
        return new PostService();
    }

}
