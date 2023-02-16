package softuni.examprepbattleships.validations.passwordMatcher;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import softuni.examprepbattleships.domain.models.binding.UserRegisterModel;

//to write the validation logic we must implement the constraintValidator<the annotation interface that we created, where we will use the annotation>
public class PasswordMatcher implements ConstraintValidator<PasswordMatch, UserRegisterModel> {

    //use the default method don't change it
    @Override
    public void initialize(PasswordMatch constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    //here we write the test logic
    @Override
    public boolean isValid(UserRegisterModel userRegisterModel, ConstraintValidatorContext context) {

        //if the validation is passed with no errors
        if (userRegisterModel.getPassword() != null &&
                userRegisterModel.getPassword().equals(userRegisterModel.getConfirmPassword())) {
            return true;
        }

        //else if the validation has any errors

        // need to be done like here.
        context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                .addPropertyNode(userRegisterModel.getConfirmPassword())
                .addConstraintViolation()
                .disableDefaultConstraintViolation();

        return false;
    }
}
