package softuni.examprepbattleships.validations.checkShipExistence;

import jakarta.validation.Constraint;
import softuni.examprepbattleships.validations.passwordMatcher.PasswordMatcher;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = PasswordMatcher.class)
public @interface ValidateExistenceOfShip {


}
