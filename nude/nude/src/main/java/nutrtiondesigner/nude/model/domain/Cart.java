package nutrtiondesigner.nude.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    @Id
    @GeneratedValue
    @Column(name = "cart_code")
    private Long code;
    private int price;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "member_id", unique = true)
    private User user;

    public Cart(User user, int price) {
        this.user = user;
        this.price = price;
    }

    public void changePrice(int changePrice) {
        price = changePrice;
    }
}
