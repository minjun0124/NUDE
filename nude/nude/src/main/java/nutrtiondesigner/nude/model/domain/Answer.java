package nutrtiondesigner.nude.model.domain;

import lombok.Getter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter
public class Answer {

    @Id
    @GeneratedValue
    @Column(name = "answer_code")
    private Long code;
    private String contents;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "question_coce")
    private Question questions;
}
