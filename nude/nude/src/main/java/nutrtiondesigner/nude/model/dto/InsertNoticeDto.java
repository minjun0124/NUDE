package nutrtiondesigner.nude.model.dto;

import lombok.Data;
import nutrtiondesigner.nude.model.domain.Notice;

@Data
public class InsertNoticeDto {
    private String title;
    private String contents;

    public Notice toEntity() {
        return Notice.builder()
                .title(title)
                .contents(contents)
                .viewcount(0)
                .build();
    }
}
