package nutrtiondesigner.nude.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartInsertDto {
    private Long itemCode;
    private int quantity;
}
