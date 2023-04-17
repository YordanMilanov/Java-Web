package bg.softuni.pizzashop.model.binding;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@ExtendWith(MockitoExtension.class)
public class UserRegisterBindingModelTests {

    @Test
    public void testValidModel() {
        UserRegisterBindingModel model = new UserRegisterBindingModel();
        model.setUsername("testuser");
        model.setFullName("Test User");
        model.setEmail("test@example.com");
        model.setPhone("1234567890");
        model.setPassword("password");
        model.setConfirmPassword("password");
        model.setCity("Sofia");
        model.setNeighborhood("Mladost");
        model.setStreet("Alexander Malinov");
        model.setStreetNumber(42);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Assertions.assertTrue(validator.validate(model).isEmpty());
    }

    @Test
    public void testInvalidModel() {
        UserRegisterBindingModel model = new UserRegisterBindingModel();
        model.setUsername("test");
        model.setFullName("Test User Test User Test User Test User Test User Test User Test User Test User Test User Test User Test User");
        model.setEmail("test@example");
        model.setPhone("12345");
        model.setPassword("pass");
        model.setConfirmPassword("pass");
        model.setCity("S");
        model.setNeighborhood("N");
        model.setStreet("S");
        model.setStreetNumber(-1);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Assertions.assertFalse(validator.validate(model).isEmpty());
    }
}
