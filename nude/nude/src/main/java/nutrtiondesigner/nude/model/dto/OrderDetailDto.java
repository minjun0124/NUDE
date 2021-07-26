package nutrtiondesigner.nude.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import nutrtiondesigner.nude.model.enumeration.OrderStatus;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class OrderDetailDto {
//    TODO: Auditing
//    private LocalDateTime orderDate;
    private Long code;
    private List<ItemDetailDto> itemList;
    private int price;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
