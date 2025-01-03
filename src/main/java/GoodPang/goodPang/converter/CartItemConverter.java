package GoodPang.goodPang.converter;

import GoodPang.goodPang.domain.cart.CartItem;
import GoodPang.goodPang.domain.item.Item;
import GoodPang.goodPang.web.dto.CartItemRequestDto;
import GoodPang.goodPang.web.dto.CartItemResponseDto;


public class CartItemConverter {

    public static CartItemResponseDto.AddResultDto toAddCartItemResult(CartItem cartItem) {
        return CartItemResponseDto.AddResultDto.builder()
                .cartItemID(cartItem.getId())
                .build();
    }

    public static CartItem toCartItem(CartItemRequestDto.AddCartItem request, Item item) {
        return CartItem.builder()
                .item(item)
                .count(request.getCount())
                .build();
    }
}
