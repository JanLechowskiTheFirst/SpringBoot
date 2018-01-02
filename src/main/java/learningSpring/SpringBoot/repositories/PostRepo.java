package learningSpring.SpringBoot.repositories;

import learningSpring.SpringBoot.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<PostEntity, Long> {
    List<PostEntity> findByEmail(String email);
}