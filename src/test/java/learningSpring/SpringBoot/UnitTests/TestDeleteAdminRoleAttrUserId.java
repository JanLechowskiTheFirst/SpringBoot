package learningSpring.SpringBoot.UnitTests;

import learningSpring.SpringBoot.TestConfigurations.UserRoleServiceTestConfig;
import learningSpring.SpringBoot.entities.UserRole;
import learningSpring.SpringBoot.enums.RoleEnum;
import learningSpring.SpringBoot.repositories.RoleRepo;
import learningSpring.SpringBoot.services.UserRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {UserRoleServiceTestConfig.class})
@RunWith(SpringRunner.class)
public class TestDeleteAdminRoleAttrUserId {

    @MockBean
    RoleRepo roleRepo;

    @Autowired
    UserRoleService userRoleService;

    @Test
    public void deleteAdminRole(){
        List<UserRole> roleList = new ArrayList<>();
        roleList.add(new UserRole(1, 1, RoleEnum.ADMIN));

        when(roleRepo.findByUserId(1)).thenReturn(roleList);

        userRoleService.deleteAdminRole(1);
    }
}

