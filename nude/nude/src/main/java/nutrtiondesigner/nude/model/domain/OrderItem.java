package nutrtiondesigner.nude.model.domain;


import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class OrderItem {
    @Id
    @GeneratedValue
    private Long code;
    private int price;
}
