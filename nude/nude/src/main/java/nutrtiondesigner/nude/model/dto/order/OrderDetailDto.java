package nutrtiondesigner.nude.model.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import nutrtiondesigner.nude.model.domain.Orders;
import nutrtiondesigner.nude.model.dto.item.ItemDto;
import nutrtiondesigner.nude.model.enumeration.OrderStatus;
import org.springframework.data.domain.Page;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class OrderDetailDto {
    private Long orderCode;
    private LocalDateTime orderDate;
    private List<ItemDto> itemList;
    private int price;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public OrderDetailDto(Orders orders, Page<ItemDto> itemList) {
        orderCode = orders.getCode();
        orderDate = orders.getCreatedDate();
        this.itemList = itemList.getContent();
        price= orders.getPrice();
        orderStatus= orders.getStatus();
    }
}
