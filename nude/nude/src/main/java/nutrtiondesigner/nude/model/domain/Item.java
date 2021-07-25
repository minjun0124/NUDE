package nutrtiondesigner.nude.model.domain;


import lombok.*;
import nutrtiondesigner.nude.model.enumeration.StockStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @Enumerated(EnumType.STRING)
    private StockStatus status = StockStatus.IN_STOCK;
    @NonNull
    private int stock;
    @NonNull
    private int price;
    private int rating;
    private double calories = 0;
    private double carbohydrate = 0;
    private double protein = 0;
    private double fat = 0;
    private double vegetable = 0;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CategoryItem> categoryItems = new ArrayList<>();

}
