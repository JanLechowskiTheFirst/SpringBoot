package learningSpring.SpringBoot.entities;

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

    public UserRole(int userId, String userRole){
        this.userId=userId;
        this.userRole=userRole;
    }

    public Users getUserEntity(){ return users; }

    public int getUserId(){
        return userId;
    }

    public String getUserRole(){
        return userRole;
    }


}
