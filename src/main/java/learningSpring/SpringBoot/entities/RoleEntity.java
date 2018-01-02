package learningSpring.SpringBoot.entities;

import javax.persistence.*;

@Entity
@Table(
        name="UserRole",
        uniqueConstraints={@UniqueConstraint(columnNames={"email", "userRole"})}
)
public class RoleEntity {
    @Id
    private String email;
    private String userRole;
    @ManyToOne
    @JoinColumn(name = "userRole")
    private UserEntity userEntity;

    protected RoleEntity(){
    }

    public RoleEntity(String email, String userRole){
        this.email=email;
        this.userRole=userRole;
    }

    public UserEntity getUserEntity(){ return userEntity; }

    public String getUserEmail(){
        return email;
    }

    public String getUserRole(){
        return userRole;
    }


}
