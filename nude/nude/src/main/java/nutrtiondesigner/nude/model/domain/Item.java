package nutrtiondesigner.nude.model.domain;


import lombok.*;
import nutrtiondesigner.nude.model.enumeration.StockStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "item_code")
    private Long code;
    @NonNull
    private String name;
    @Column(name = "img_path")
    private String imgPath;
    private StockStatus status = StockStatus.IN_STOCK;
    @NonNull
    private int stock;
    @NonNull
    private int price;
    private double calories = 0;
    private double carbohydrate = 0;
    private double protein = 0;
    private double fat = 0;
    private double vegetable = 0;
}
