package nutrtiondesigner.nude.model.domain;

import lombok.Getter;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private int password;
    private String name;
    private String email;
    private String phone;
    private Address address;

}
