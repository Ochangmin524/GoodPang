package GoodPang.goodPang.web.dto;

import lombok.Getter;
import lombok.Setter;


public class CartItemRequestDto {
    @Getter
    @Setter
    public static class AddCartItem{
        Long memberId;//장바구니 주인
        Long itemId; //장바구니에 넣을 상품 id
        Integer count; //상품 개수
    }


}
