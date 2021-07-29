package nutrtiondesigner.nude.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Answer {

    @Id
    @GeneratedValue
    @Column(name = "answer_code")
    private Long code;
    private String contents;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "question_code")
    private Question questions;
}
