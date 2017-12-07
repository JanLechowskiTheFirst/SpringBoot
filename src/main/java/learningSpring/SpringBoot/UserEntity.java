package learningSpring.SpringBoot;


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

    protected UserEntity(){
    }

    public UserEntity(String email, String password){
        this.email=email;
        this.pass=password;
    }

    public List<PostEntity> getPost() {
        return postEntity;
    }

    public String getLogin(){
        return this.email;
    }

    public String getPassword(){return this.pass;}
}
