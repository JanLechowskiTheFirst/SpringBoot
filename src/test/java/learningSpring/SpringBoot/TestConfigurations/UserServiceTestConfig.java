package learningSpring.SpringBoot.TestConfigurations;

import learningSpring.SpringBoot.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserServiceTestConfig {
    @Bean
    UserService userService() {
        return new UserService();
    }
}
