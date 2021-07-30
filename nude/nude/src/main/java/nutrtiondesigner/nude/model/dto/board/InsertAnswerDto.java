package nutrtiondesigner.nude.model.dto.board;

import lombok.Data;
import nutrtiondesigner.nude.model.domain.Answer;
import nutrtiondesigner.nude.model.domain.Question;

@Data
public class InsertAnswerDto {

    private String contents;

    public Answer toEntity(Question question) {
        return Answer.builder()
                .contents(contents)
                .questions(question)
                .build();
    }
}
