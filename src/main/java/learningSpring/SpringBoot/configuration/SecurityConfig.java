package learningSpring.SpringBoot.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.debug(true);
    }

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
            .usersByUsernameQuery(
                    "select email,pass,enabled from UserEntity where email=?")
            .authoritiesByUsernameQuery(
                    "select u.email, r.userRole from UserEntity u inner join UserRole r on (r.email=u.email) where u.email=?");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/login","/","login?logout").permitAll()
          //TODO nie działą i nie wiem dlaczego  .antMatchers("/admin/**").access("hasRole('admin')")
            .anyRequest().authenticated()
            .and()
            .formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password")
            .and()
            .logout().logoutSuccessUrl("/login?logout")
            .and()
            .exceptionHandling().accessDeniedPage("/403")
            .and()
            .csrf();
    }
}


