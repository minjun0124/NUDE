package nutrtiondesigner.nude.model.form;

import lombok.Data;
import lombok.NoArgsConstructor;
import nutrtiondesigner.nude.model.domain.Item;
import nutrtiondesigner.nude.model.enumeration.StockStatus;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@NotNull
public class ItemUpLoadForm {
    private MultipartFile img;
    private String category;
    private String name;
    private int stock;
    private int price;
    private double calories = 0;
    private double carbohydrate = 0;
    private double protein = 0;
    private double fat = 0;
    private double vegetable = 0;

    public Item toEntity(String imgPath) {
        return Item.builder()
                .name(name)
                .imgPath(imgPath)
                .status(StockStatus.IN_STOCK)
                .stock(stock)
                .price(price)
                .calories(calories)
                .carbohydrate(carbohydrate)
                .protein(protein)
                .fat(fat)
                .vegetable(vegetable)
                .build();
    }
}