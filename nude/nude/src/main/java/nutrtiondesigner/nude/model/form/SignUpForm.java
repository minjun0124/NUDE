package nutrtiondesigner.nude.model.form;

import lombok.Data;
import lombok.NonNull;
import nutrtiondesigner.nude.model.domain.Address;
import nutrtiondesigner.nude.model.domain.Member;

@Data
public class SignUpForm {

    @NonNull
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

    public SignUpForm(Member member) {
        id = member.getId();
        password = member.getPassword();
        username = member.getUsername();
        email = member.getEmail();
        phone = member.getPhone();
        address = member.getAddress();
    }
}
