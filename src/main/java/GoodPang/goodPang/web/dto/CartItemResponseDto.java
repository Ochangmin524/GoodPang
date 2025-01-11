package GoodPang.goodPang.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class CartItemResponseDto {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    //생성된 장바구니 상품의 id 반환
    public static class AddResultDto {
        Long cartItemID;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetCartItemResultDto {
        Integer numOfCartItems;
        List<CartItemDto> cartItems;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CartItemDto {
        Long cartItemId;
        Long itemId;
        String itemName;
        Integer price;
        Integer quantity;

    }
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DeleteCartItemResultDto {
        Long cartItemId; //삭제한 장바구니 상품의 아이디

    }
}
