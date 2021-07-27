package nutrtiondesigner.nude.model.dto.order;

import lombok.Data;
import nutrtiondesigner.nude.model.dto.item.ItemInsertDto;

import java.util.List;

@Data
public class OrderInsertDto {
    private List<ItemInsertDto> codeList;
    private int price;
}
