package nutrtiondesigner.nude.model.domain;

import lombok.Getter;
import lombok.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    @NonNull
    private int password;
    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private String phone;
    @NonNull
    private Address address;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Cart cart;
}
