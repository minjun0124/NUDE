package nutrtiondesigner.nude.model.dto.cart;

import lombok.Data;

@Data
public class UpdateCartDto {
    private Long cartCode;
    private Long itemCode;
    private int quantity;
}
