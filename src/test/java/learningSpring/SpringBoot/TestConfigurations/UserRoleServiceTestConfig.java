package learningSpring.SpringBoot.TestConfigurations;

import learningSpring.SpringBoot.services.UserRoleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserRoleServiceTestConfig {
    @Bean
    UserRoleService roleService() {
        return new UserRoleService();
    }
}
