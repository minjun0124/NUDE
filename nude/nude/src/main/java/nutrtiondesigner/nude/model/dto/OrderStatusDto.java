package nutrtiondesigner.nude.model.dto;

import lombok.Data;
import nutrtiondesigner.nude.model.enumeration.OrderStatus;

@Data
public class OrderStatusDto {
    private Long ordercode;
    private OrderStatus orderStatus;
}
