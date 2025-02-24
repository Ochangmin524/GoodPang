package GoodPang.goodPang.api.dto;

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
    @Getter
    @Setter
    public static class DeleteCartItem{
        Long cartId;//샂제할 장바구니 상품의 장바구니 아이디
        Long cartItemId; //삭제할 장바구니 상품의 아이디
    }
    @Getter
    @Setter
    public static class updateCartItemQuantity{
        Long cartItemId;//수정할 장바구니 상품의 아이디
        Integer quantity; // 장바구니 상품의 개수
    }


}
