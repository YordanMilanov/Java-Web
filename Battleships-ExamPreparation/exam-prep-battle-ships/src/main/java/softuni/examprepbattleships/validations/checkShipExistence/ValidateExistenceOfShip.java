package softuni.examprepbattleships.validations.checkShipExistence;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import softuni.examprepbattleships.validations.passwordMatcher.PasswordMatcher;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD) //here we set what type of element we will validate
@Constraint(validatedBy = ShipExistenceValidator.class)
public @interface ValidateExistenceOfShip {

    // this 3 methods are messages which have to be added in every annotation for validation.
    // massage if there is any errors.
    String message() default "Ship name is taken";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
