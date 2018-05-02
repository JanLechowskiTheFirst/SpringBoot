package learningSpring.SpringBoot.UnitTests;

import learningSpring.SpringBoot.TestConfigurations.UserRoleServiceTestConfig;
import learningSpring.SpringBoot.entities.UserRole;
import learningSpring.SpringBoot.repositories.RoleRepo;
import learningSpring.SpringBoot.services.UserRoleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {UserRoleServiceTestConfig.class})
@RunWith(SpringRunner.class)
public class TestGetAllRolesReturnsAllRolesList {
    @MockBean
    RoleRepo roleRepo;

    @Autowired
    UserRoleService userRoleService;

    @Test
    public void getAllRolesTest() {
        List<UserRole> roleList = new ArrayList<>();
        roleList.add(mock(UserRole.class));
        roleList.add(mock(UserRole.class));

        when(roleRepo.findAllWithEmail()).thenReturn(roleList);

        Assert.assertEquals(2, userRoleService.getAllRoles().size());
    }
}
