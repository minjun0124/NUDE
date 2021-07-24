package nutrtiondesigner.nude.model.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import nutrtiondesigner.nude.model.domain.Address;
import nutrtiondesigner.nude.model.domain.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpForm {

    @NotNull
    @Size(min = 3, max = 50)
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    @Size(min = 3, max = 100)
    private String password;

    @NotNull
    @Size(min = 3, max = 50)
    private String email;

    @NotNull
    @Size(min = 3, max = 50)
    private String phone;

//    @NotNull
    private Address address;

}
