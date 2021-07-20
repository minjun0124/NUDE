package nutrtiondesigner.nude.model.domain;


import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class CategoryItem {
    @Id
    @GeneratedValue
    private Long code;
}
