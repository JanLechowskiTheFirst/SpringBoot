package learningSpring.SpringBoot.UnitTests;

import learningSpring.SpringBoot.TestConfigurations.UserServiceTestConfig;
import learningSpring.SpringBoot.forms.UserForm;
import learningSpring.SpringBoot.repositories.RoleRepo;
import learningSpring.SpringBoot.repositories.UserRepo;
import learningSpring.SpringBoot.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {UserServiceTestConfig.class})
@RunWith(SpringRunner.class)
public class TestAddUserToDBAttrForm {

    @MockBean
    RoleRepo roleRepo;
    @MockBean
    UserRepo userRepo;
    @MockBean
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserService userService;

    @Test
    public void addNewUser(){
        UserForm form = new UserForm();
        form.setEmail("abc@pl.pl");
        form.setPassword("12345");

        when(bCryptPasswordEncoder.encode(anyString())).thenReturn("*(!&@*#&)!");
        when(userRepo.findUserIdByEmail("abc@pl.pl")).thenReturn(1);

        userService.addUserToDB(form);
    }


}
