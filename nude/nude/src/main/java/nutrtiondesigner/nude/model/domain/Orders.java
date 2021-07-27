package nutrtiondesigner.nude.model.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import nutrtiondesigner.nude.model.dto.OrderStatusDto;
import nutrtiondesigner.nude.model.enumeration.OrderStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue
    @Column(name = "order_code")
    private Long code;
    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.PENDING;
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private User user;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();

    public Orders(User user, int price) {
        this.status = OrderStatus.PENDING;
        this.user = user;
        this.price = price;
    }

    public void updateStatus(OrderStatusDto orderStatusDto) {
        status = orderStatusDto.getOrderStatus();
    }
}
