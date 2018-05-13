package learningSpring.SpringBoot.repositories;

import learningSpring.SpringBoot.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface RoleRepo extends JpaRepository<UserRole, Integer> {

      @Query("SELECT ur.userId, ur.userRole, u.email FROM UserRole ur, Users u where u.id=ur.userId order by ur.userRole asc")
      List<UserRole> findAllWithEmail();

      List<UserRole> findByUserId(int userId);

}
