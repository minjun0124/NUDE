package nutrtiondesigner.nude.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nutrtiondesigner.nude.model.form.SignUpForm;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @JsonIgnore
    @Id
    @Column(name = "user_id")
    @GeneratedValue
    private Long id;

    @Column(name = "username", length = 50, unique = true)
    private String username;

    @JsonIgnore
    @Column(name = "password", length = 100)
    private String password;

    private String email;
    private String phone;

    @Embedded
    private Address address;

    /**
     * 활성화 여부
     */
    @JsonIgnore
    @Column(name = "activated")
    private boolean activated;

//    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Question> questions = new ArrayList<>();
//
//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
//    private Cart cart;

    @ManyToMany
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
    private Set<Authority> authorities;

    public void updateInfo(SignUpForm signUpForm, String changePw) {
        username = signUpForm.getUsername();
        password = changePw;
        email = signUpForm.getEmail();
        phone = signUpForm.getPhone();
        address = signUpForm.getAddress();
    }
}
