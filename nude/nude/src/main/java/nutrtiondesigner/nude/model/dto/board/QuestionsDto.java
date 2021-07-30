package nutrtiondesigner.nude.model.dto.board;

import lombok.Data;
import nutrtiondesigner.nude.model.domain.Question;

import java.time.LocalDateTime;

@Data
public class QuestionsDto {
    private String title;
    //TODO: Auditing
//    private LocalDateTime createdDate;
    private Long questionCode;
    private String contents;
    private Boolean isAnswered;

    public QuestionsDto(Question q) {
        title = q.getTitle();
        questionCode = q.getCode();
        contents = q.getContents();
        isAnswered = q.getIsAnswered();
    }
}
