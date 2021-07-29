package nutrtiondesigner.nude.model.domain;

import lombok.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "questions", orphanRemoval = true)
    private List<Answer> answers = new ArrayList<>();

}
