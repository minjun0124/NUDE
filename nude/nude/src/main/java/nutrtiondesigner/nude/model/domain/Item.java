package nutrtiondesigner.nude.model.domain;


import lombok.Getter;
import lombok.NonNull;
import nutrtiondesigner.nude.model.enumeration.StockStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "item_code")
    private Long code;
    @NonNull
    private String name;
    private StockStatus status = StockStatus.IN_STOCK;
    @NonNull
    private int stock;
    private double calories = 0;
    private double carbohydrate = 0;
    private double protein = 0;
    private double fat = 0;
    private double vegetable = 0;
    @NonNull
    private int price;
}
