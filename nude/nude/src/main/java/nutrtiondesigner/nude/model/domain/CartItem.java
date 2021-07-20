package nutrtiondesigner.nude.model.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class CartItem {

    @Id
    @GeneratedValue
    private Long code;

}
