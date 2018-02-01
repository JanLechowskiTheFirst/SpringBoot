package learningSpring.SpringBoot.forms;

import java.sql.Timestamp;

public class PostForm {
    private int id;
    private String post;
    private int user_id;
    private Timestamp postDate;
    private String content;

    public int getId(){
        return id;
    }

    public String getPostText(){
        return post;
    }

    public int getUserId(){
        return user_id;
    }

    public Timestamp getPostDate(){
        return postDate;
    }


    public String getContent(){
        return content;
    }

    public void setDate(){
        this.postDate= new Timestamp(System.currentTimeMillis());
    }

    public void setId(int id){
        this.user_id=id;
    }

    public void setPost(String post){
        this.post=post;
    }

    public void setContent(String content){
        this.content = content;
    }
}
