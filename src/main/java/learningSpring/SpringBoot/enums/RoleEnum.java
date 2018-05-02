package learningSpring.SpringBoot.enums;

public enum RoleEnum {
    ADMIN {
        public String toString() {
            return "ROLE_admin";
        }
    } ,

    USER {
        public String toString() {
            return "ROLE_user";
        }
    }
}
