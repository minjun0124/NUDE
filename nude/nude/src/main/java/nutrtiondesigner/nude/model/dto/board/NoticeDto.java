package nutrtiondesigner.nude.model.dto.board;

import lombok.Data;
import nutrtiondesigner.nude.model.domain.Notice;

import java.time.LocalDateTime;

@Data
public class NoticeDto {
    private Long code;
    private String title;
    private String contents;
    private String adminName;
    private LocalDateTime createdTime;
    private int viewCount;

    public NoticeDto(Notice notice) {
        code = notice.getCode();
        title = notice.getTitle();
        adminName = notice.getCreatedBy();
        createdTime = notice.getCreatedDate();
        viewCount = notice.getViewcount();
    }
}
