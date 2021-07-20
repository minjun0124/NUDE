package nutrtiondesigner.nude.model.domain;


import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class CategoryItem {
    @Id
    @GeneratedValue
    private Long code;

    @ManyToOne
    @JoinColumn(name = "category_code")
    Category category;

    @ManyToOne
    @JoinColumn(name = "item_code")
    Item item;
}
