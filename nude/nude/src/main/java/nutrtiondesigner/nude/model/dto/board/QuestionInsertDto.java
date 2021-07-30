package nutrtiondesigner.nude.model.dto.board;

import lombok.Data;
import nutrtiondesigner.nude.model.domain.Question;
import nutrtiondesigner.nude.model.domain.User;

@Data
public class QuestionInsertDto {

    private String title;
    private String contents;
    private Boolean isAnswered;


    public Question toEntity(User user) {
        return Question.builder()
                .user(user)
                .title(title)
                .contents(contents)
                .isAnswered(false)
                .build();
    }
}
