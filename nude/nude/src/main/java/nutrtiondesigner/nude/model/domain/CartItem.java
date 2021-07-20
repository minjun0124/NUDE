package nutrtiondesigner.nude.model.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class CartItem {

    @Id
    @GeneratedValue
    private Long code;

    @ManyToOne
    @JoinColumn(name = "cart_code")
    Cart cart;

    @ManyToOne
    @JoinColumn(name = "item_code")
    Item item;
}
