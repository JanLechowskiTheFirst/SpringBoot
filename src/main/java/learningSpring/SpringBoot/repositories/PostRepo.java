package learningSpring.SpringBoot.repositories;

import learningSpring.SpringBoot.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    @Query("SELECT p FROM Post p, Users u WHERE u.id = p.userId and u.email =:userEmail order by p.postDate desc")
    List<Post> findAllPostsByUserEmailSortedAsc(@Param("userEmail")String email);
}