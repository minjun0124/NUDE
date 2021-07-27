package nutrtiondesigner.nude.model.dto.order;

import lombok.Data;
import nutrtiondesigner.nude.model.domain.Orders;
import nutrtiondesigner.nude.model.enumeration.OrderStatus;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class OrderListDto {
    private Long orderCode;
//    TODO: Auditing - 주문 일자
//    private LocalDateTime orderDate;
    private int price;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public OrderListDto(Orders orders) {
        orderCode = orders.getCode();
        price = orders.getPrice();
        orderStatus = orders.getStatus();
    }
}
