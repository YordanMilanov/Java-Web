package softuni.examprepbattleships.validations.checkShipExistence;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import softuni.examprepbattleships.repositories.ShipRepository;

public class ShipExistenceValidator implements ConstraintValidator<ValidateExistenceOfShip, String> {

    private ShipRepository shipRepository;

    public ShipExistenceValidator(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    @Override
    public void initialize(ValidateExistenceOfShip constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String shipName, ConstraintValidatorContext constraintValidatorContext) {
        return this.shipRepository.findByName(shipName).isEmpty();
    }
}
