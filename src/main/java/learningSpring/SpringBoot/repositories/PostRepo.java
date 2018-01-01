package learningSpring.SpringBoot.repositories;

import learningSpring.SpringBoot.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<PostEntity, Long> {}