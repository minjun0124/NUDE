package nutrtiondesigner.nude.model.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Notice {
    @Id
    @GeneratedValue
    @Column(name = "notice_code")
    private Long code;
    private String title;
    private String contents;
    @Column(name = "view_count")
    private int viewcount;
}
