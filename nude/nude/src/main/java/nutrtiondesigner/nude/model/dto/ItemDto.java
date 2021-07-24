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
public class ItemDto {
    private String img;
    private String category;
    private String name;
    private int stock;
    private int price;
    private double calories = 0;
    private double carbohydrate = 0;
    private double protein = 0;
    private double fat = 0;
    private double vegetable = 0;

    public ItemDto(Item item, String categoryName) {
        category = categoryName;
        img = item.getImgPath();
        name = item.getName();
        stock = item.getStock();
        price = item.getPrice();
        calories = item.getCalories();
        carbohydrate = item.getCarbohydrate();
        protein = item.getProtein();
        fat = item.getFat();
        vegetable = item.getVegetable();
    }
}