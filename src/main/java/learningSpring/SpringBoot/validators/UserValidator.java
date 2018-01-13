package learningSpring.SpringBoot.validators;

import learningSpring.SpringBoot.forms.UserForm;
import learningSpring.SpringBoot.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator{

    @Autowired
    UserRepo userRepo;

    @Override
    public boolean supports(Class<?> clazz) {
        return UserForm.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors err) {
        UserForm user = (UserForm) obj;

        ValidationUtils.rejectIfEmptyOrWhitespace(err, "email", "NotEmpty");
        if (user.getEmail().length() < 6 || user.getEmail().length() > 30) {
            err.rejectValue("email", "email.size");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(err, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 30) {
            err.rejectValue("password", "password.size");
        }

                if (userRepo.findOneByMail(user.getEmail()) != null) {
            err.rejectValue("email", "email.duplicated");
        }

        if (!user.getPassword().equals(user.getPassword2())) {
            err.rejectValue("password2", "password2.different");
        }
    }

}

