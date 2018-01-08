package learningSpring.SpringBoot.repositories;

import learningSpring.SpringBoot.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {
    List<Post> findByUserId(int userId);
}