package nutrtiondesigner.nude.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class DeleteCartDto {
    private Long cartcode;
    private List<Long> itemcodes;
}
