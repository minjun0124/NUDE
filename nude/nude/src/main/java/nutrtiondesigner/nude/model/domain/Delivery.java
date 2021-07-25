package nutrtiondesigner.nude.model.domain;


import lombok.Getter;
import lombok.NonNull;
import nutrtiondesigner.nude.model.enumeration.DelivStatus;

import javax.persistence.*;

@Entity
@Getter
public class Delivery {
    @Id
    @GeneratedValue
    private Long code;
    @NonNull
    private Address address;
    @Enumerated(EnumType.STRING)
    private DelivStatus status = DelivStatus.PREPARING;

    @ManyToOne
    @JoinColumn(name = "order_code")
    private Orders orders;
}
