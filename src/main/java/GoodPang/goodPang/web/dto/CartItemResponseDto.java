package GoodPang.goodPang.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CartItemResponseDto {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    //생성된 장바구니 상품의 id 반환
    public static class AddResultDto {
        Long cartItemID;
    }
}
