package bg.softuni.resellerapplication.model.service;

import bg.softuni.resellerapplication.model.entity.Condition;
import bg.softuni.resellerapplication.model.enums.ConditionName;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OfferServiceModel {


    private String Description;

    private Double price;

    private ConditionName condition;
}
