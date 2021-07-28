package nutrtiondesigner.nude.model.dto.order;

import lombok.Data;
import nutrtiondesigner.nude.model.enumeration.OrderStatus;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class OrderStatusDto {
    private Long orderCode;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
