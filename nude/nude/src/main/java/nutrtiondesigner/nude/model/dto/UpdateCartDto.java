package nutrtiondesigner.nude.model.dto;

import lombok.Data;

@Data
public class UpdateCartDto {
    private Long cartcode;
    private Long itemcode;
    private int quantity;
}
