package learningSpring.SpringBoot.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
            .usersByUsernameQuery(
                    "select email,pass from UserEntity where email=?")
            .authoritiesByUsernameQuery(
                    "select email, userRole from UserRole where email=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers( "/").permitAll()
            .antMatchers("/**").access("hasRole('admin')")
            .anyRequest().authenticated()
            .and()
            .formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password").permitAll() //or email pass
            .and()
            .logout().logoutSuccessUrl("/login?logout").permitAll()
            .and()
            .exceptionHandling().accessDeniedPage("/403")
            .and()
            .csrf();
    }

    //Tylko do prostych testow
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER");
//    }
}


