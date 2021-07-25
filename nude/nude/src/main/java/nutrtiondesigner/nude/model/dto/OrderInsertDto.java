package nutrtiondesigner.nude.model.dto;

import lombok.Data;

import java.util.List;

/**
 *
 * {
 *     "cartItemList": [
 *         {
 *             "img": "95972fe4-cabe-4f73-a1b9-8fad580f4e5d_KakaoTalk_20210717_214606150.jpg",
 *             "category": null,
 *             "name": "vege100",
 *             "stock": 1250,
 *             "price": 3200,
 *             "rating": 0,
 *             "calories": 86.0,
 *             "carbohydrate": 3.0,
 *             "protein": 100.0,
 *             "fat": 10.0,
 *             "vegetable": 2.0,
 *             "quantity": 3
 *         },
 *         {
 *             "img": "11df78d4-41fe-4ac6-997d-0b72d71cc966_KakaoTalk_20210717_214606150.jpg",
 *             "category": null,
 *             "name": "pork",
 *             "stock": 1250,
 *             "price": 3200,
 *             "rating": 0,
 *             "calories": 86.0,
 *             "carbohydrate": 3.0,
 *             "protein": 100.0,
 *             "fat": 10.0,
 *             "vegetable": 2.0,
 *             "quantity": 2
 *         },
 *         {
 *             "img": "ef054907-efb5-4f0f-8a08-a1782110fc4e_KakaoTalk_20210718_011725816_15.jpg",
 *             "category": null,
 *             "name": "pork2",
 *             "stock": 1250,
 *             "price": 3200,
 *             "rating": 0,
 *             "calories": 86.0,
 *             "carbohydrate": 3.0,
 *             "protein": 100.0,
 *             "fat": 10.0,
 *             "vegetable": 2.0,
 *             "quantity": 7
 *         }
 *     ],
 *     "sumNutrition": {
 *         "calories": 1032.0,
 *         "carbohydrate": 36.0,
 *         "protein": 1200.0,
 *         "fat": 120.0,
 *         "vegetable": 24.0
 *     },
 *     "price": 44800
 * }
 */
@Data
public class OrderInsertDto {
    private List<OrderItemDto> codeList;
    private int price;
}
