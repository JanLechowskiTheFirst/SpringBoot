package learningSpring.SpringBoot.services;

import learningSpring.SpringBoot.entities.UserRole;
import learningSpring.SpringBoot.repositories.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class
UserRoleService {

    @Autowired
    RoleRepo roleRepo;

    public boolean hasRoleAdmin(List<UserRole> role, int userId){

        for(UserRole r:role){
            if(r.getUserId() == userId && r.getUserRole().equals("ROLE_admin"))
                return true;
        }
        return false;
    }

    public List<UserRole> getAllRoles(){
        return roleRepo.findAllWithEmail();

    }

    public void addAdminAdmin(int userId) {
        List<UserRole> role = roleRepo.findByUserId(userId);
        UserRole adminRole = new UserRole(userId, "ROLE_admin");
        if(!hasRoleAdmin(role, userId)) {
            roleRepo.saveAndFlush(adminRole);
        }
        else{
            //todo
        }
    }

    public void deleteAdminRole(int userId) {
        List<UserRole> role = roleRepo.findByUserId(userId);
        UserRole adminRole = new UserRole(role.get(0).id, userId, "ROLE_admin");
        if(hasRoleAdmin(role, userId)) {
            roleRepo.delete(adminRole);
        }
        else{
            //todo
        }
    }
}
