package learningSpring.SpringBoot.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class UserEntity {

   @Id
   private String email;
   private String pass;
   @OneToMany(mappedBy = "userEntity")
   private List<PostEntity> postEntity;
   @OneToMany(mappedBy = "userEntity")
   private List<RoleEntity> roleEntity;

    protected UserEntity(){
    }

    public UserEntity(String email, String password){
        this.email=email;
        this.pass=password;
    }

    public List<PostEntity> getPost() {
        return postEntity;
    }

    public List<RoleEntity> getRole() {
        return roleEntity;
    }

    public String getLogin(){
        return this.email;
    }

    public String getPassword(){return this.pass;}
}
