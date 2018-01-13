package learningSpring.SpringBoot.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users", uniqueConstraints={@UniqueConstraint(columnNames={"email"})})
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

    public Users(String email, String password){
        this.enabled=1;
        this.email=email;
        this.pass=password;
    }

    public List<Post> getPosts() {
        return Posts;
    }

    public List<UserRole> getRoles() {
        return UserRoles;
    }

    public void setPosts(List<Post> Posts){
        this.Posts=Posts;
    }

    public void setRolesList(List<UserRole> UserRoles){
        this.UserRoles= UserRoles;
    }

    public Integer getId(){
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

    public void setPassword(String password){
        this.pass=password;
    }

    public void setEmail(String email){
        this.email=email;
    }
}
