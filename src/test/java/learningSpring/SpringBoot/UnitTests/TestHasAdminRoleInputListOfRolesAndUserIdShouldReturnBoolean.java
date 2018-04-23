package learningSpring.SpringBoot.UnitTests;


import learningSpring.SpringBoot.entities.UserRole;
import learningSpring.SpringBoot.services.UserRoleService;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class TestHasAdminRoleInputListOfRolesAndUserIdShouldReturnBoolean {
    
    @Test
    public void whenUserIsNotAdmin(){
        UserRoleService roleService = new UserRoleService();

        List<UserRole> roleList = new ArrayList<>();

        UserRole role1 =  new UserRole(1, 1, "ROLE_user");
        UserRole role2 =  new UserRole(2, 1, "ROLE_admin");
        UserRole role3 =  new UserRole(3, 2, "ROLE_user");
        UserRole role4 =  new UserRole(4, 3, "ROLE_user");

        roleList.add(role1);
        roleList.add(role2);
        roleList.add(role3);
        roleList.add(role4);

        Assert.assertEquals(true, roleService.hasRoleAdmin(roleList, 1));
    }

    @Test
    public void whenUserIsAdmin(){
        UserRoleService roleService = new UserRoleService();

        List<UserRole> roleList = new ArrayList<>();

        UserRole role1 =  new UserRole(1, 1, "ROLE_user");
        UserRole role2 =  new UserRole(3, 2, "ROLE_user");
        UserRole role3=  new UserRole(4, 3, "ROLE_user");

        roleList.add(role1);
        roleList.add(role2);
        roleList.add(role3);

        Assert.assertEquals(false, roleService.hasRoleAdmin(roleList, 1));
    }

    
}

