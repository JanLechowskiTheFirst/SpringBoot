package learningSpring.SpringBoot.UnitTests;


import learningSpring.SpringBoot.entities.UserRole;
import learningSpring.SpringBoot.enums.RoleEnum;
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

        UserRole role1 =  new UserRole(1, 1, RoleEnum.USER);
        UserRole role2 =  new UserRole(2, 1, RoleEnum.ADMIN);
        UserRole role3 =  new UserRole(3, 2, RoleEnum.USER);
        UserRole role4 =  new UserRole(4, 3, RoleEnum.USER);

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

        UserRole role1 =  new UserRole(1, 1, RoleEnum.USER);
        UserRole role2 =  new UserRole(3, 2, RoleEnum.USER);
        UserRole role3=  new UserRole(4, 3, RoleEnum.USER);

        roleList.add(role1);
        roleList.add(role2);
        roleList.add(role3);

        Assert.assertEquals(false, roleService.hasRoleAdmin(roleList, 1));
    }

    
}

