package nutrtiondesigner.nude.model.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Notice {
    @Id
    @GeneratedValue
    @Column(name = "notice_code")
    private Long code;
    @NonNull
    private String title;
    private String contents;
    @Column(name = "view_count")
    private int viewcount;

    public void upViewCount() {
        viewcount += 1;
    }
}
