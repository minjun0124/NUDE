package nutrtiondesigner.nude.model.domain;

import lombok.Getter;
import lombok.NonNull;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
@Getter
public class Question {

    @Id
    @GeneratedValue
    @Column(name = "question_code")
    private Long code;
    @NonNull
    private String title;
    private String contents;
    private Boolean isAnswered;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private User user;

    @OneToMany(mappedBy = "questions", orphanRemoval = true)
    private List<Answer> answers = new ArrayList<>();

}
