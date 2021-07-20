package nutrtiondesigner.nude.model.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
}
