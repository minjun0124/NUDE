package nutrtiondesigner.nude.model.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import nutrtiondesigner.nude.model.dto.item.ItemDto;
import nutrtiondesigner.nude.model.enumeration.OrderStatus;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Data
@AllArgsConstructor
public class OrderDetailDto {
//    TODO: Auditing
//    private LocalDateTime orderDate;
    private Long orderCode;
    private List<ItemDto> itemList;
    private int price;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
