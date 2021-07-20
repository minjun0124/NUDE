package nutrtiondesigner.nude.model.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Cart {

    @Id
    @GeneratedValue
    @Column(name = "cart_code")
    private Long code;
    private int price;
}
