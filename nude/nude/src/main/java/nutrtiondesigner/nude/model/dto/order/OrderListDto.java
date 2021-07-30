package nutrtiondesigner.nude.model.dto.order;

import lombok.Data;
import nutrtiondesigner.nude.model.domain.Orders;
import nutrtiondesigner.nude.model.enumeration.OrderStatus;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Data
public class OrderListDto {
    private Long orderCode;
    private LocalDateTime orderDate;
    private int price;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public OrderListDto(Orders orders) {
        orderCode = orders.getCode();
        price = orders.getPrice();
        orderDate = orders.getCreatedDate();
        orderStatus = orders.getStatus();
    }
}
