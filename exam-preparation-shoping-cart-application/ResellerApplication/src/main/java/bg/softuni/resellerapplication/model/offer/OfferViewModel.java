package bg.softuni.resellerapplication.model.offer;

import bg.softuni.resellerapplication.model.entity.Condition;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OfferViewModel {

    private Long id;
    private Condition condition;
    private Double price;
    private String description;
}
