package learningSpring.SpringBoot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class MvCConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //TODO obsługa błędów http
    }

    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(oracle.jdbc.driver.OracleDriver.class.getName());
        driverManagerDataSource.setUrl("jdbc:oracle:thin:SYSTEM/flash1@localhost:1521:XE");
        driverManagerDataSource.setUsername("SYSTEM");
        driverManagerDataSource.setPassword("flash1");
        return driverManagerDataSource;
    }

}
