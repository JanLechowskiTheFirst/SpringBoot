package learningSpring.SpringBoot.repositories;

import learningSpring.SpringBoot.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<RoleEntity, String> {}
