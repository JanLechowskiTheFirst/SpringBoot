package learningSpring.SpringBoot;

public class LoginForm {

    private String email;
    private String password;
    private String content;

    public String getEmail(){ return email;
    }

    public String getPassword(){
        return password;
    }

    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }
}
