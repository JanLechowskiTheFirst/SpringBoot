package learningSpring.SpringBoot.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="post")
public class Post {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "pst_id")
    @Column(name="id")
    public Integer id;
    @Column(name="user_id")
    private int userId;
    @Column(name="post")
    private String post;
    @Basic(optional = false)
    @Column(name="post_date", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date postDate;
    @ManyToOne(targetEntity = Users.class)
    @JoinColumn(name="user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Users users;

    protected Post(){}

    public Post(int userId, String post){
        this.userId=userId;
        this.post=post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Users getUserEntity(){ return users; }

    public int getUserId(){
        return userId;
    }

    public String getPost(){
        return post;
    }

    public Date getPostDate() {
        return postDate;
    }

}



