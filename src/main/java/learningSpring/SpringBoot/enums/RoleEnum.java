package learningSpring.SpringBoot.enums;

public enum RoleEnum {
    ADMIN("ROLE_admin"),
    USER("ROLE_user");

    private String text;

    RoleEnum(String text) {
        this.text = text;
    }

    public String returnDesc() {
        return text;
    }

    public static RoleEnum getEnumByDesc(String text){
        if(text.equals("ROLE_admin")) return RoleEnum.ADMIN;
        else return RoleEnum.USER;
    }

}
