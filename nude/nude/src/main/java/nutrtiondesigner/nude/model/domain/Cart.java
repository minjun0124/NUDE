package nutrtiondesigner.nude.model.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Cart {

    @Id
    @GeneratedValue
    @Column(name = "cart_code")
    private Long code;
    private int price;

    @OneToOne
    @JoinColumn(name = "member_id")
    Member member;
}
