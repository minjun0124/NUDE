package nutrtiondesigner.nude.model.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Authority {

    /**
     * 권한명
     */
    @Id
    @Column(name = "authority_name", length = 50)
    private String authorityName;

}
