package nutrtiondesigner.nude.model.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import nutrtiondesigner.nude.model.form.SignUpForm;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    @NonNull
    private String username;
    @NonNull
    private String password;
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

    public Member(SignUpForm signUpForm) {
        id = signUpForm.getId();
        password = signUpForm.getPassword();
        username = signUpForm.getUsername();
        email = signUpForm.getEmail();
        phone = signUpForm.getPhone();
        address = signUpForm.getAddress();
    }
}
