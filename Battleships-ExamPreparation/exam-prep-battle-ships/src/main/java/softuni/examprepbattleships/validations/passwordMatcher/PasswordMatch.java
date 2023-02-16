package softuni.examprepbattleships.validations.passwordMatcher;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) //here we set what type of element we will validate
@Constraint(validatedBy = PasswordMatcher.class)
public @interface PasswordMatch {


    // this 3 methods are messages which have to be added in every annotation for validation.
    String message() default "Password miss match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
