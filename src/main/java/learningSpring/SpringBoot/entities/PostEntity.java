package learningSpring.SpringBoot.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class PostEntity {
    @Id
    private String email;
    @ManyToOne
    @JoinColumn(name = "postEntity")
    private UserEntity userEntity;
    private String post;
    private String postDate;

    public PostEntity(){}

    public PostEntity(String post, String email){
        this.post=post;
        this.email=email;
    }
    public UserEntity getUserEntity(){ return userEntity; }

    public String getUserEmail(){
        return email;
    }

    public String getPost(){
        return post;
    }

    public String getPostDate() {
        return postDate;
    }

}
