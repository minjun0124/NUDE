package nutrtiondesigner.nude.model.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nutrtiondesigner.nude.model.dto.item.ItemDto;
import nutrtiondesigner.nude.model.dto.util.SumNutrition;

import java.util.List;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartListDto {
    private Long cartCode;
    private List<ItemDto> cartItemList;
    private SumNutrition sumNutrition;
    private int price;

    public CartListDto(Long code, List<ItemDto> itemList, int changePrice) {
        cartCode = code;
        cartItemList = itemList;
        price = changePrice;
        sumNutrition = new SumNutrition();
        for (ItemDto cartItem : itemList) {
            sumNutrition.sum(cartItem);
        }
    }
}
