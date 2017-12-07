package learningSpring.SpringBoot;

import java.util.Date;

public class PostForm {
    private String post;
    private String date;
    private String content;

    public String getPostDate(){return date;}

    public String getPostText(){
        return post;
    }

    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }
}
