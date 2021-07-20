package nutrtiondesigner.nude.model.domain;

import lombok.Getter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter
public class Question {

    @Id
    @GeneratedValue
    @Column(name = "question_code")
    private Long code;
    private String title;
    private String contents;
    private Boolean isAnswered;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    Member member;
}
