package nutrtiondesigner.nude.model.dto.board;

import lombok.Builder;
import lombok.Data;
import nutrtiondesigner.nude.model.domain.Answer;

@Data
public class AnswerDto {
    private Long answerCode;
    private String contents;

    public AnswerDto(Answer answer) {
        answerCode = answer.getCode();
        contents = answer.getContents();
    }
}
