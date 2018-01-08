package learningSpring.SpringBoot.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class Users {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "usr_id")
    @Column(name="id")
    @JoinColumn
    public Integer id;
    @Column(name="email")
    private String email;
    @Column(name="pass")
    private String pass;
    @Column(name="enabled")
    private int enabled;
    @OneToMany(mappedBy = "users")
    private List<Post> Posts;
    @OneToMany(mappedBy = "users")
    private List<UserRole> UserRoles;

    protected Users(){
    }

    public Users(String email, String password, int enabled){
        this.email=email;
        this.pass=password;
        this.enabled=enabled;
    }

    public List<Post> getPosts() {
        return Posts;
    }

    public List<UserRole> getRoles() {
        return UserRoles;
    }

    public int getId(){
        return id;
    }

    public String getEmail(){
        return email;
    }

    public String getLogin(){
        return this.email;
    }

    public String getPassword(){return this.pass;}

    public int getEnabled(){return this.enabled;}
}
