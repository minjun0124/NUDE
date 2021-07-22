package nutrtiondesigner.nude.model.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
@Getter
public class Cart {

    @Id
    @GeneratedValue
    @Column(name = "cart_code")
    private Long code;
    private int price;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "member_id", unique = true)
    private User user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItem;
}
