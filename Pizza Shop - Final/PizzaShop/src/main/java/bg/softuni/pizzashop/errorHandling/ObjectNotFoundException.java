package bg.softuni.pizzashop.errorHandling;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.function.Supplier;


@Getter
public class ObjectNotFoundException extends RuntimeException{

    private final Long objectId;
    private final String objectType;

    public ObjectNotFoundException(Long objectId, String objectType) {
        super("Object of type: " + objectType + "with id:" + objectId + "was not found!");
        this.objectId = objectId;
        this.objectType = objectType;
    }

}
