package nutrtiondesigner.nude.model.domain;


import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class OrderItem {
    @Id
    @GeneratedValue
    private Long code;
    private int price;

    @ManyToOne
    @JoinColumn(name = "order_code")
    Orders orders;

    @ManyToOne
    @JoinColumn(name = "item_code")
    Item item;
}
