package learningSpring.SpringBoot.entities;

import learningSpring.SpringBoot.enums.RoleEnum;
import javax.persistence.*;

@Entity
@Table(name="user_role", uniqueConstraints={@UniqueConstraint(columnNames={"user_id", "user_role"})})
public class UserRole {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "pst_id")
    @Column(name="id")
    public Integer id;
    @Column(name="user_id")
    @JoinTable(name="Users")
    private int userId;
    @Column(name="user_role")
    private String userRole;
    @ManyToOne(targetEntity = Users.class)
    @JoinColumn(name="user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Users users;

    protected UserRole(){
    }

    public Users getUsers(){
        return users;
    }

    public UserRole(int userId, RoleEnum userRole){
        this.userId=userId;
        this.userRole=userRole.returnDesc();
    }

    public UserRole(int id, int userId, RoleEnum userRole){
        this.id=id;
        this.userId=userId;
        this.userRole=userRole.returnDesc();
    }

    public UserRole(int id, int userId, RoleEnum userRole, Users user){
        this.id=id;
        this.userId=userId;
        this.userRole=userRole.returnDesc();
        this.users=user;
    }

    public Users getUserEntity(){ return users; }

    public int getUserId(){
        return userId;
    }

    public RoleEnum getUserRole(){
        return RoleEnum.getEnumByDesc(userRole);
    }
    
    public void setUserId(int userId){
        this.userId=userId;
    }

    public void setUserRole(RoleEnum userRole){
        this.userRole=userRole.returnDesc();
    }

    public void setId(int id){
        this.id=id;
    }

    public int getId(){
        return id;
    }

}
