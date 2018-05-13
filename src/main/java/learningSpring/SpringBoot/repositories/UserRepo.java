package learningSpring.SpringBoot.repositories;


import learningSpring.SpringBoot.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepo extends JpaRepository<Users, Integer> {
    List<Users> findByEmail(String email);
    @Query("SELECT u FROM Users u WHERE ROWNUM = 1 AND LOWER(u.email) = LOWER(:email)")
    Users findOneByMail(@Param("email") String email);

    @Query("SELECT u.id FROM Users u WHERE ROWNUM = 1 AND LOWER(u.email) = LOWER(:email)")
    int findUserIdByEmail(@Param("email")String email);
}
