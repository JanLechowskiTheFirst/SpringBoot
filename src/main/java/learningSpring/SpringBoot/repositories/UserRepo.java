package learningSpring.SpringBoot.repositories;


import learningSpring.SpringBoot.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, String> {}
