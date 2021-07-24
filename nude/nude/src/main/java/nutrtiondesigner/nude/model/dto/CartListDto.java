package nutrtiondesigner.nude.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartListDto {
    private List<CartItemDto> cartItemList;
    private SumNutrition sumNutrition;
    private int price;

    public CartListDto(List<CartItemDto> itemList, int price) {
        cartItemList = itemList;
        this.price = price;
        sumNutrition = new SumNutrition();
        for (CartItemDto cartItem : itemList) {
            sumNutrition.sum(cartItem);
        }
    }
}
