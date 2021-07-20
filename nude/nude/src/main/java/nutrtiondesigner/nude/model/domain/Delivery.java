package nutrtiondesigner.nude.model.domain;


import lombok.Getter;
import nutrtiondesigner.nude.model.enumeration.DelivStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Delivery {
    @Id
    @GeneratedValue
    private Long code;
    private Address address;
    private DelivStatus status;
}
