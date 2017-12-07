package learningSpring.SpringBoot;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class UserEntity {

   @Id
   private String email;
   private String pass;
   private Set<PostEntity> posts;

    protected UserEntity(){
    }

    public UserEntity(String email, String password){
        this.email=email;
        this.pass=password;
    }

    @OneToMany(mappedBy = "user")
    public Set<PostEntity> getPost() {
        return posts;
    }

    public String getLogin(){
        return this.email;
    }

    public String getPassword(){return this.pass;}
}
