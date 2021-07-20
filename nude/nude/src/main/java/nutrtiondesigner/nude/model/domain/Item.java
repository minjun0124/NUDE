package nutrtiondesigner.nude.model.domain;


import lombok.Getter;
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
    private String name;
    private StockStatus status;
    private int stock;
    private double calories;
    private double carbohydrate;
    private double protein;
    private double fat;
    private double vegetable;
    private int price;
}
