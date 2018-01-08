package learningSpring.SpringBoot.repositories;

import learningSpring.SpringBoot.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<UserRole, Integer> {}
