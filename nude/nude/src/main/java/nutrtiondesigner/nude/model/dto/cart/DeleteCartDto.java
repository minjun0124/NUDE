package nutrtiondesigner.nude.model.dto.cart;

import lombok.Data;

import java.util.List;

@Data
public class DeleteCartDto {
    private Long cartCode;
    private List<Long> itemCodes;
}
