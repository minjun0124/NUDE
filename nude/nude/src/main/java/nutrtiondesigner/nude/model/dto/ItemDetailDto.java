package nutrtiondesigner.nude.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nutrtiondesigner.nude.model.domain.Item;

@Slf4j
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemDetailDto {
    private Long code;
    private String img;
    private String category;
    private String name;
    private int stock;
    private int price;
    private int rating;
    private double calories = 0;
    private double carbohydrate = 0;
    private double protein = 0;
    private double fat = 0;
    private double vegetable = 0;
    private int quantity = 0;

    public ItemDetailDto(Item item, int quantity) {
        code = item.getCode();
        img = item.getImgPath();
        name = item.getName();
        stock = item.getStock();
        price = item.getPrice();
        rating = item.getRating();
        calories = item.getCalories();
        carbohydrate = item.getCarbohydrate();
        protein = item.getProtein();
        fat = item.getFat();
        vegetable = item.getVegetable();
        this.quantity = quantity;
    }
}
