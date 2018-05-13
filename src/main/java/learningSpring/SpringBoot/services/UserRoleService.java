package learningSpring.SpringBoot.services;

import learningSpring.SpringBoot.entities.UserRole;
import learningSpring.SpringBoot.enums.RoleEnum;
import learningSpring.SpringBoot.repositories.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class
UserRoleService {

    @Autowired
    RoleRepo roleRepo;

    private static final Logger LOGGER = Logger.getLogger(UserRoleService.class.getName() );

    public boolean hasRoleAdmin(List<UserRole> role, int userId){
        for(UserRole r:role){
            if(r.getUserId() == userId && r.getUserRole() == RoleEnum.ADMIN)
                return true;
        }
        return false;
    }

    public List<UserRole> getAllRoles(){
        return roleRepo.findAllWithEmail();

    }

    public void addAdminAdmin(int userId) {
        List<UserRole> role = roleRepo.findByUserId(userId);
        UserRole adminRole = new UserRole(userId, RoleEnum.ADMIN);
        if(!hasRoleAdmin(role, userId)) {
            roleRepo.saveAndFlush(adminRole);
        }
        else{
            LOGGER.log( Level.FINE, "ERROR: Adding ADMIN rights for ADMIN user");

        }
    }

    public void deleteAdminRole(int userId) {
        List<UserRole> role = roleRepo.findByUserId(userId);
        UserRole adminRole = new UserRole(role.get(0).id, userId, RoleEnum.ADMIN);
        if(hasRoleAdmin(role, userId)) {
            roleRepo.delete(adminRole);
        }
        else{
            LOGGER.log( Level.FINE, "ERROR: Deleting ADMIN rights from non ADMIN user");

        }
    }
}
