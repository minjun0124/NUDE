package nutrtiondesigner.nude.model.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Orders {
    @Id
    @GeneratedValue
    @Column(name = "order_code")
    private Long code;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    Member member;
}
