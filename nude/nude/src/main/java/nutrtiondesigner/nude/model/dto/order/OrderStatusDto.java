package nutrtiondesigner.nude.model.dto.order;

import lombok.Data;
import nutrtiondesigner.nude.model.enumeration.OrderStatus;

@Data
public class OrderStatusDto {
    private Long orderCode;
    private OrderStatus orderStatus;
}
