package nutrtiondesigner.nude.model.domain;

import lombok.Getter;
import nutrtiondesigner.nude.model.enumeration.OrderStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Orders {
    @Id
    @GeneratedValue
    @Column(name = "order_code")
    private Long code;
    private OrderStatus status = OrderStatus.PENDING;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private User user;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();
}
