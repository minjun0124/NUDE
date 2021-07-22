package nutrtiondesigner.nude.model.form;

import lombok.Data;
import lombok.NonNull;
import nutrtiondesigner.nude.model.domain.Address;
import nutrtiondesigner.nude.model.domain.Member;

@Data
public class SignInForm {

    @NonNull
    private Long id;
    @NonNull
    private String password;

}
